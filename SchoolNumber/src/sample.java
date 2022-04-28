
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

	// �w�Z�����ԍ��Ɗw�Z�R�[�h�̑Δ�\�t�@�C��
	private static final String FILE_PATH = "�w�Z�����ԍ��Ɗw�Z�R�[�h�̑Δ�\.txt";

	// 01_���w�Z_���s_�����t�@�C��
	private static final String ELEMENTARY_FILE_PATH = "01_���w�Z_���s_����.txt";

	public static void main(String[] args) throws Exception {

		String[] oldnumber = null;
		String[] newnumber = null;
		String[] elementarynumber = null;

		//�w�Z�����ԍ��p�̃��X�g
		List<String> oldnumberList = new ArrayList<String>();

		//�w�Z�R�[�h�p�̃��X�g
		List<String> newnumberList = new ArrayList<String>();

		//���w�Z_���s_�����t�@�C���̏��w�Z���R�[�h�p�̃��X�g
		List<String> elementarynumberList = new ArrayList<String>();



		// �t�@�C���̓ǂݍ���
		read(oldnumberList, newnumberList);

		// �w�Z�����ԍ���z��ɕϊ�
		oldnumber = (String[])oldnumberList.toArray(new String[0]);

		//�w�Z�R�[�h��z��ɕϊ�
		newnumber = (String[])newnumberList.toArray(new String[0]);

		// �t�@�C���̓ǂݍ���
		elementaryread(elementarynumberList);

		//01_���w�Z_���s_�����t�@�C���̏��w�Z���R�[�h��z��ɕϊ�
		elementarynumber = (String[])elementarynumberList.toArray(new String[0]);

		Map<String, String> map = new HashMap<>();
		for(int i = 0; i < oldnumber.length; ++i) {

				map.put(oldnumber[i], newnumber[i]);

		}
		for(Map.Entry<String, String> entry : map.entrySet()){
		    System.out.println(entry.getKey() + ":" + entry.getValue());
		}
	}

	// �w�Z�����ԍ��Ɗw�Z�R�[�h�̑Δ�\�t�@�C�����擾
	private static void read(List<String> oldnumberList, List<String> newnumberList) {
		BufferedReader br = null;
		try {

			br = new BufferedReader(new FileReader(FILE_PATH));
			String line = null;

			// �w�Z�����ԍ��Ɗw�Z�R�[�h����s���ǂݍ���
			while ((line = br.readLine()) != null) {

				String[] array = line.split(",");

				if (array.length == 2) {

					oldnumberList.add(array[0]);
					newnumberList.add(array[1]);
				}
			}

			// �ȉ��G���[����
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

	// 01_���w�Z_���s_�����t�@�C�����擾
	private static void elementaryread(List<String> elementarynumberList) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(ELEMENTARY_FILE_PATH));
			String line = null;

			// 01_���w�Z_���s_�����t�@�C���t�@�C������s���ǂݍ���
			while ((line = br.readLine()) != null) {

				elementarynumberList.add(line);

			}

			// �ȉ��G���[����
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