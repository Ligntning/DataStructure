package sduwh.cp.sorts;

import java.util.Scanner;

/*
 * 快速排序主要的排序思想是分而治之(Divide-and-ConquerMethod)
 * 平均时间复杂度为O(nlog2n),最好情况下为O(nlog2n),最坏情况下为O(n^2)
 * 空间复杂度为最好的情况下O(log2n),最坏的情况下为O(n),但是可以通过随机选择pivotkey使复杂度维持在O(log2n)
 */
public class QuickSort {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("请输入数组，数字用空格间隔：");
		String[] strArr = input.nextLine().split(" ");
		int[] numArr = new int[strArr.length];
		for (int i = 0; i < strArr.length; i++) {
			numArr[i] = Integer.parseInt(strArr[i]);
		}
		QuickSort qs = new QuickSort();
		qs.quickSort(numArr, 0, numArr.length - 1);
		for (int j = 0; j <= numArr.length - 1; j++) {
			System.out.print(numArr[j] + " ");
		}
	}

	/*
	 * 将数组a[low...high]按照枢轴分成两部分，在枢轴之前的不大于它， 在枢轴之后的不小于它 并且返回枢轴的最终位置
	 */
	private int partition(int[] a, int low, int high) {
		int pivotkey = a[low];
		while (low < high) {
			while (low < high && a[high] >= pivotkey)
				--high;
			a[low] = a[high];
			while (low < high && a[low] <= pivotkey)
				++low;
			a[high] = a[low];
		}
		a[low] = pivotkey;
		return low;
	}

	/* 快速排序 */
	private void quickSort(int[] a, int low, int high) {
		int pivotloc;
		if (low < high) {
			pivotloc = partition(a, low, high);
			quickSort(a, low, pivotloc - 1);
			quickSort(a, pivotloc + 1, high);
		}
	}

}
