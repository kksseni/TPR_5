package org.example;

import java.text.DecimalFormat;
import java.util.*;

public class AlgorithmService {

	private Point[][] matrix;
	private List<Double> scale;
	private List<String> headers;

	public void fillCriteriaMatrix(int amountOfCriteria) {
		fillScale();
		fillHeaders();
		matrix = new Point[amountOfCriteria][amountOfCriteria];
		for (int i = 0; i < amountOfCriteria; i++) {
			for (int j = 0; j < amountOfCriteria; j++) {
				if (i == j) {
					matrix[i][j] = new Point(1);
				} else if (i < j) {
					matrix[i][j] = compareCriteria();
				} else {
					matrix[i][j] = new Point(1.0 / matrix[j][i].getValue());
				}
			}
		}

		countOwnVector();
		countWeightOfCriteria();
	}

	private void countOwnVector() {
		for (int i = 0; i < matrix.length; i++) {
			matrix[i][matrix.length - 1].setOwnVector(Math.pow(matrix[i][0].getValue() * matrix[i][1].getValue() * matrix[i][2].getValue(), 1.0 / matrix.length));
		}
	}

	private void countWeightOfCriteria() {
		for (int i = 0; i < matrix.length; i++) {
			matrix[i][matrix.length - 1].setWeightOfCriteria(matrix[i][matrix.length - 1].getOwnVector() / (matrix[0][matrix.length - 1].getOwnVector() +
					matrix[1][matrix.length - 1].getOwnVector() + matrix[2][matrix.length - 1].getOwnVector()));
		}
	}

	private void fillHeaders() {
		headers = new ArrayList<>();
		headers.add("C1");
		headers.add("C2");
		headers.add("C3");
	}

	private Point compareCriteria() {
		int scaleIndex = getRandomIndex(scale);
		return Point.builder()
				.value(scale.get(scaleIndex))
				.build();
	}

	public static int getRandomIndex(List<Double> scale) {
		Random random = new Random();
		return random.nextInt(scale.size());
	}


	private void fillScale() {
		scale = new ArrayList<>();
		scale.add(1.0);
		scale.add(3.0);
		scale.add(5.0);
		scale.add(7.0);
		scale.add(9.0);
	}

	public void printMatrix() {
		DecimalFormat decimalFormat = new DecimalFormat("#.##");
		decimalFormat.setMaximumFractionDigits(2);
		decimalFormat.setMinimumFractionDigits(2);

		System.out.print("\t");
		for (String header : headers) {
			System.out.print(String.format("%-7s", header));
		}
		System.out.print(String.format("%-7s %-7s", "W", "w"));
		System.out.println();

		for (int i = 0; i < matrix.length; i++) {
			System.out.print(headers.get(i) + "\t");
			for (int j = 0; j < matrix.length; j++) {
				System.out.print(String.format("%-7s", decimalFormat.format(matrix[i][j].getValue())));
			}
			System.out.print(String.format("%-7s", decimalFormat.format(matrix[i][matrix.length - 1].getOwnVector())));
			System.out.print(String.format("%-7s", decimalFormat.format(matrix[i][matrix.length - 1].getWeightOfCriteria())));
			System.out.println();
		}
	}


}