package redmart;

import java.util.List;

public class Result implements Cloneable {
	Result(int decent, int length, int xi, int yi, List<Integer> arList) {
		this.decent = decent;
		this.length = length;
		this.xi = xi;
		this.yi = yi;
		this.path = arList;
	}

	int decent;
	int length;
	List<Integer> path;
	int xi;
	int yi;

	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	public Result compare(Result input) {
		if(input.decent > this.decent) {
			return input;
		}else if (input.decent == this.decent && input.length >= this.length) {
			return input;
		}else {
			return this;
		}
	}
}