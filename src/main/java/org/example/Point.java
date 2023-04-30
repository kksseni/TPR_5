package org.example;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Point {
	private double value;
	private boolean isWorse;
	List<String> header;
	private double ownVector;
	private double weightOfCriteria;
}
