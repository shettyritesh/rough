package com.rit.externalmerge;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.Stream;

public class ExternalMergeSorter {
	private int temporaryArraySizeLimit;
	private int[] arr1;
	private int[] arr2;
	private int[] result;
	private String destinationDir = "c://temp/externalmerge/";
	private MyFileUtil myfileutil;

	public ExternalMergeSorter(int maxRecordsInMemory) {
		temporaryArraySizeLimit = maxRecordsInMemory / 3;
		arr1 = new int[temporaryArraySizeLimit];
		arr2 = new int[temporaryArraySizeLimit];
		result = new int[temporaryArraySizeLimit];
		myfileutil = new MyFileUtil();
	}

	public void sort(String hugeInputFileName) throws IOException {

		File originalFile = new File(destinationDir + "//" + hugeInputFileName);
		int numberoffiles = myfileutil.splitFile(originalFile, temporaryArraySizeLimit, "em_", destinationDir);

		for (int i = 0; i < numberoffiles; i++) {
			String fileFullpath = getInputFilename(i);
			int numberofrecords = myfileutil.readFromFile(arr1, fileFullpath);
			Arrays.sort(arr1, 0, (numberofrecords));
			myfileutil.write2File(arr1, fileFullpath, numberofrecords);
		}
		merge(0, numberoffiles - 1);
		createOutputfile(numberoffiles);

	}

	private String getInputFilename(int i) {
		return destinationDir + "em_" + i;
	}

	private String getOutputFilename(int i) {
		return destinationDir + "emr_" + i;
	}

	void merge(int start, int end) throws IOException {
		if (end > start) {
			int center = start + (end - start) / 2;
			merge(start, center);
			merge(center + 1, end);
			domerge(start, center, end);
		}
	}

	void domerge(int start, int center, int end) throws IOException {

		int i = start;
		int j = center + 1;

		int maxrecords1 = myfileutil.readFromFile(arr1, getInputFilename(i));
		int maxrecords2 = myfileutil.readFromFile(arr2, getInputFilename(j));
		int filecount = 0;
		if (i <= center && j <= end) {

			int k = 0;
			int p = 0;
			int q = 0;
			// Keep comparing till atleast all files are processed from first
			// half
			while (p < maxrecords1 && q < maxrecords2) {

				if (arr1[p] < arr2[q]) {
					result[k] = arr1[p];
					p++;
				} else {
					result[k] = arr2[q];
					q++;
				}
				k++;

				if (p >= maxrecords1 && i < center) {
					i++;
					arr1 = new int[maxrecords1];
					maxrecords1 = myfileutil.readFromFile(arr1, getInputFilename(i));
					p = 0;

				}
				if (q >= maxrecords2 && j < end) {
					j++;
					arr2 = new int[maxrecords2];
					maxrecords2 = myfileutil.readFromFile(arr2, getInputFilename(j));
					q = 0;

				}
				// Flush to file
				if (k == temporaryArraySizeLimit) {
					myfileutil.write2File(result, getOutputFilename(start + filecount), temporaryArraySizeLimit);
					k = 0;
					result = new int[temporaryArraySizeLimit];
					filecount++;
				}

			}

			while (p < maxrecords1) {
				result[k] = arr1[p];
				p++;
				k++;
				if (k == temporaryArraySizeLimit) {
					myfileutil.write2File(result, getOutputFilename(start + filecount), temporaryArraySizeLimit);
					k = 0;
					result = new int[temporaryArraySizeLimit];
					filecount++;
				}
				if (p >= maxrecords1 && i < center) {
					i++;
					arr1 = new int[temporaryArraySizeLimit];
					maxrecords1 = myfileutil.readFromFile(arr1, getInputFilename(i));
					p = 0;

				}

			}

			while (q < maxrecords2) {
				result[k] = arr2[q];
				q++;
				k++;
				if (k == temporaryArraySizeLimit) {
					myfileutil.write2File(result, getOutputFilename(start + filecount), temporaryArraySizeLimit);
					k = 0;
					filecount++;
				}
				if (q >= maxrecords2 && j < end) {
					j++;
					arr2 = new int[temporaryArraySizeLimit];
					maxrecords2 = myfileutil.readFromFile(arr2, getInputFilename(j));
					q = 0;

				}

			}

			if (k < temporaryArraySizeLimit) {
				myfileutil.write2File(result, getOutputFilename(start + filecount), k);
			}

		}
		for (int c = start; c <= end; c++) {
			File processedfile = new File(getOutputFilename(c));
			File originalfile = new File(getInputFilename(c));
			originalfile.delete();
			boolean renamed = processedfile.renameTo(originalfile);
			System.out.println("Renamed " + processedfile.getAbsoluteFile() + " to " + originalfile.getAbsoluteFile());
		}

	}
	
	//TODO The real code shouldnt read all contents into memory. Scope of this is not to write utility to append the files
	private void createOutputfile(int numberoffiles) throws IOException {
		File sortedfile = new File(destinationDir + "/outputfile");
		FileWriter fw = new FileWriter(sortedfile);
		for (int c = 0; c < numberoffiles; c++) {

			Stream<String> stream = Files.lines(Paths.get(getInputFilename(c)));
			Iterator<String> iter = stream.iterator();
			int i = 0;
			while (iter.hasNext()) {
				fw.write(iter.next());
				fw.write("\n");
			}
			File originalfile = new File(getInputFilename(c));
			originalfile.delete();
			stream.close();
		}
		fw.close();
	}

}

class MyFileUtil {
	public void sort(String filename) {

	}

	public int readFromFile(int[] arr, String filename) throws IOException {
		File file = new File(filename);
		Stream<String> stream = Files.lines(Paths.get(filename));
		Iterator<String> iter = stream.iterator();
		int i = 0;
		while (iter.hasNext()) {
			arr[i++] = Integer.parseInt(iter.next());
		}
		stream.close();
		return i;

	}

	public static void write2File(int[] arr, String filename, int highlimit) throws IOException {
		FileWriter fw = new FileWriter(filename);
		try {
			for (int i = 0; i < highlimit; i++) {
				if (i != 0) {
					fw.write("\n");
				}
				fw.write(String.valueOf(arr[i]));

			}
		} finally {
			fw.close();
		}
	}
//TODO The real code shouldnt read all contents into memory. Scope of this is not to write utility to split the file
	public int splitFile(File originalHugeFile, int sizePerFile, String filePrefix, String destination)
			throws IOException {
		Stream<String> stream = Files.lines(Paths.get(originalHugeFile.getAbsoluteFile().getPath()));
		Iterator<String> iter = stream.iterator();
		int filenumseq = 0;
		int i = 0;
		FileWriter fw = null;
		while (iter.hasNext()) {
			if (i == 0) {
				File newfile = new File(destination + "\\" + filePrefix + filenumseq);
				fw = new FileWriter(newfile);
				filenumseq++;
			} else {
				fw.write("\n");
			}
			fw.write(iter.next());
			i++;
			if (i == sizePerFile) {
				fw.close();
				i = 0;
			}
		}
		fw.close();
		stream.close();
		return filenumseq;

	}

}