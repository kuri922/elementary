
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class sample {

	// 学校調査番号と学校コードの対比表ファイル
	private static final String FILE_PATH = "学校調査番号と学校コードの対比表.txt";

	// 01_小学校_大阪市_公立ファイル
	private static final String ELEMENTARY_FILE_PATH = "01_小学校_大阪市_公立.txt";

	public static void main(String[] args) throws Exception {

		String[] oldnumber = null;
		String[] newnumber = null;
		String[] elementarynumber = null;

		//学校調査番号用のリスト
		List<String> oldnumberList = new ArrayList<String>();

		//学校コード用のリスト
		List<String> newnumberList = new ArrayList<String>();

		//小学校_大阪市_公立ファイルの小学校情報コード用のリスト
		List<String> elementarynumberList = new ArrayList<String>();



		// ファイルの読み込み
		read(oldnumberList, newnumberList);

		// 学校調査番号を配列に変換
		oldnumber = (String[])oldnumberList.toArray(new String[0]);

		//学校コードを配列に変換
		newnumber = (String[])newnumberList.toArray(new String[0]);

		// ファイルの読み込み
		elementaryread(elementarynumberList);

		//01_小学校_大阪市_公立ファイルの小学校情報コードを配列に変換
		elementarynumber = (String[])elementarynumberList.toArray(new String[0]);

		Map<String, String> map = new HashMap<>();
		for(int i = 0; i < oldnumber.length; ++i) {

				map.put(oldnumber[i], newnumber[i]);

		}
		for(Map.Entry<String, String> entry : map.entrySet()){
		    System.out.println(entry.getKey() + ":" + entry.getValue());
		}
	}

	// 学校調査番号と学校コードの対比表ファイルを取得
	private static void read(List<String> oldnumberList, List<String> newnumberList) {
		BufferedReader br = null;
		try {

			br = new BufferedReader(new FileReader(FILE_PATH));
			String line = null;

			// 学校調査番号と学校コードを一行ずつ読み込む
			while ((line = br.readLine()) != null) {

				String[] array = line.split(",");

				if (array.length == 2) {

					oldnumberList.add(array[0]);
					newnumberList.add(array[1]);
				}
			}

			// 以下エラー処理
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// 01_小学校_大阪市_公立ファイルを取得
	private static void elementaryread(List<String> elementarynumberList) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(ELEMENTARY_FILE_PATH));
			String line = null;

			// 01_小学校_大阪市_公立ファイルファイルを一行ずつ読み込む
			while ((line = br.readLine()) != null) {

				elementarynumberList.add(line);

			}

			// 以下エラー処理
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}


		}
	}

}