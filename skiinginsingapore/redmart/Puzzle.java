package redmart;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Puzzle {

	static int a[][] = null;
	static int x;
	static int y;

	public static void main(String[] args) throws FileNotFoundException, CloneNotSupportedException {

		Scanner in = new Scanner(new FileInputStream("E:\\workspace_r\\javaeight\\src\\redmart\\map2.txt"));
		x = in.nextInt();
		y = in.nextInt();
		a = new int[x][y];
		for (int xi = 0; xi < x; xi++) {
			for (int yi = 0; yi < y; yi++) {
				int k = in.nextInt();
				a[xi][yi] = k;
			}

		}
		Result r = new Result(0,0,0,0, new ArrayList<>());
		for (int j = 0; j < y; j++)
			r = r.compare(diveDeep(new Result(0, 0, x - 1, j, new ArrayList<>())));
			Collections.reverse(r.path);
			System.out.println(r.path);
	}
	
	

	static Result diveDeep(Result input) throws CloneNotSupportedException {
		Result output = (Result) input.clone();
		Result temp = null;
		int current = a[input.xi][input.yi];
		ArrayList<Integer> paths =  new ArrayList<>();
		paths.addAll(input.path);
		paths.add(current);
		output.path =paths;

		// up
		if (input.xi > 0 && a[input.xi - 1][input.yi] > current) {
			temp = diveDeep(new Result(input.decent + (a[input.xi - 1][input.yi] - current), input.length + 1,
					input.xi - 1, input.yi, paths));
			output = output.compare(temp);
		}
		// left
		if (input.yi > 0 && a[input.xi][input.yi-1] > current) {
			temp = diveDeep(new Result(input.decent + (a[input.xi][input.yi-1] - current), input.length + 1,
					input.xi, input.yi-1, paths));
			output = output.compare(temp);
		}

		// right
		if (input.yi+1 < y && a[input.xi][input.yi + 1] > current) {
			temp = diveDeep(new Result(input.decent + (a[input.xi][input.yi+1] - current), input.length + 1, input.xi,
					input.yi + 1,paths));
			output = output.compare(temp);
		}
		return output;

	}

}
