package Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;

public class RequestHttpURLConnection {

	public boolean checkLogin(JSONObject loginObject) {
		System.out.println("checkLogin");
		return false;
	}

	public String ServeExerciseData() throws JSONException {

		String result = "";
		try {
			// --------------------------
			// URL �����ϰ� �����ϱ�
			// --------------------------

			URL url = new URL("http://localhost:8080/Server/Exercise/ExerciseList.jsp");

			HttpURLConnection http = (HttpURLConnection) url.openConnection(); // ����
			// --------------------------
			// ���� ��� ���� - �⺻���� �����̴�
			// --------------------------
			http.setDefaultUseCaches(false);
			http.setDoInput(true); // �������� �б� ��� ����
			http.setDoOutput(true); // ������ ���� ��� ����
			http.setRequestMethod("POST"); // ���� ����� POST

			// �������� ������ <Form>���� ���� �Ѿ�� �Ͱ� ���� ������� ó���϶�� �� �˷��ش�
			http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8"); // --------------------------

			// --------------------------
			// �������� ���۹ޱ�
			// --------------------------
			InputStreamReader tmp = new InputStreamReader(http.getInputStream(), "UTF-8");
			BufferedReader reader = new BufferedReader(tmp);
			StringBuilder builder = new StringBuilder();
			String str;

			while ((str = reader.readLine()) != null) { // �������� ���δ����� ������ ���̹Ƿ� ���δ����� �д´�
				builder.append(str + "\n"); // View�� ǥ���ϱ� ���� ���� ������ �߰�
			}
			result = builder.toString();
		} catch (MalformedURLException e) {
		} catch (IOException e) {
		}
		return result;
	} // HttpPostDate

	// ----------------------------------
	/* ������ �������Ʈ �׸��� �Է��ϴ� �Լ� */
	// ----------------------------------
	public String sendMyExerciseInsert(String values) throws JSONException {

		String result = "";
		try {
			// --------------------------
			// URL �����ϰ� �����ϱ�
			// --------------------------

			URL url = new URL("http://localhost:8080/Server/Exercise/InsertMyExerciseList.jsp");
			HttpURLConnection http = (HttpURLConnection) url.openConnection(); // ����
			// --------------------------
			// ���� ��� ���� - �⺻���� �����̴�
			// --------------------------
			http.setDefaultUseCaches(false);
			http.setDoInput(true); // �������� �б� ��� ����
			http.setDoOutput(true); // ������ ���� ��� ����
			http.setRequestMethod("POST"); // ���� ����� POST

			// �������� ������ <Form>���� ���� �Ѿ�� �Ͱ� ���� ������� ó���϶�� �� �˷��ش�
			http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8"); // --------------------------
			// ������ �� ����
			// --------------------------
			StringBuffer buffer = new StringBuffer();
			String regdata = "My_exercise_data=" + values;

			buffer.append(regdata); // php ������ �� ����

			OutputStreamWriter outStream = new OutputStreamWriter(http.getOutputStream(), "UTF-8");
			PrintWriter writer = new PrintWriter(outStream);
			writer.write(buffer.toString());
			writer.flush();

			// --------------------------
			// �������� ���۹ޱ�
			// --------------------------
			InputStreamReader tmp = new InputStreamReader(http.getInputStream(), "UTF-8");
			BufferedReader reader = new BufferedReader(tmp);
			StringBuilder builder = new StringBuilder();
			String str;

			while ((str = reader.readLine()) != null) { // �������� ���δ����� ������ ���̹Ƿ� ���δ����� �д´�
				builder.append(str + "\n"); // View�� ǥ���ϱ� ���� ���� ������ �߰�
			}
			result = builder.toString();
		} catch (MalformedURLException e) {
		} catch (IOException e) {
		}
		System.out.println(result);
		return result;
	} // HttpPostDat

	public String ServeMyExerciseData(String value) throws JSONException {

		String result = "";
		try {
			// --------------------------
			// URL �����ϰ� �����ϱ�
			// --------------------------
			URL url = new URL("http://localhost:8080/Server/Exercise/myExerciseList.jsp");
			HttpURLConnection http = (HttpURLConnection) url.openConnection(); // ����
			// --------------------------
			// ���� ��� ���� - �⺻���� �����̴�
			// --------------------------
			http.setDefaultUseCaches(false);
			http.setDoInput(true); // �������� �б� ��� ����
			http.setDoOutput(true); // ������ ���� ��� ����
			http.setRequestMethod("POST"); // ���� ����� POST
			// �������� ������ <Form>���� ���� �Ѿ�� �Ͱ� ���� ������� ó���϶�� �� �˷��ش�
			http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8"); // --------------------------
			// ������ �� ����
			// --------------------------
			StringBuffer buffer = new StringBuffer();
			String regdata = "user=" + value;

			buffer.append(regdata); // php ������ �� ����

			OutputStreamWriter outStream = new OutputStreamWriter(http.getOutputStream(), "UTF-8");
			PrintWriter writer = new PrintWriter(outStream);
			writer.write(buffer.toString());
			writer.flush();
			// --------------------------
			// �������� ���۹ޱ�
			// --------------------------
			InputStreamReader tmp = new InputStreamReader(http.getInputStream(), "UTF-8");
			BufferedReader reader = new BufferedReader(tmp);
			StringBuilder builder = new StringBuilder();
			String str;

			while ((str = reader.readLine()) != null) { // �������� ���δ����� ������ ���̹Ƿ� ���δ����� �д´�
				builder.append(str + "\n"); // View�� ǥ���ϱ� ���� ���� ������ �߰�
			}
			result = builder.toString();
		} catch (MalformedURLException e) {
		} catch (IOException e) {
		}
		return result;
	} // HttpPostDate

	public String deleteMyExerciseData(JSONObject deleteData) throws JSONException {
		String result = "";

		try {
			// --------------------------
			// URL �����ϰ� �����ϱ�
			// --------------------------
			URL url = new URL("http://localhost:8080/Server/Exercise/DeleteExerciseList.jsp");
			HttpURLConnection http = (HttpURLConnection) url.openConnection(); // ����
			// --------------------------
			// ���� ��� ���� - �⺻���� �����̴�
			// --------------------------
			http.setDefaultUseCaches(false);
			http.setDoInput(true); // �������� �б� ��� ����
			http.setDoOutput(true); // ������ ���� ��� ����
			http.setRequestMethod("POST"); // ���� ����� POST
			// �������� ������ <Form>���� ���� �Ѿ�� �Ͱ� ���� ������� ó���϶�� �� �˷��ش�
			http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8"); // --------------------------
			// ������ �� ����
			// --------------------------
			StringBuffer buffer = new StringBuffer();
			String regdata = "DeleteData=" + deleteData;

			buffer.append(regdata); // php ������ �� ����

			OutputStreamWriter outStream = new OutputStreamWriter(http.getOutputStream(), "UTF-8");
			PrintWriter writer = new PrintWriter(outStream);
			writer.write(buffer.toString());
			writer.flush();

			// --------------------------
			// �������� ���۹ޱ�
			// --------------------------
			InputStreamReader tmp = new InputStreamReader(http.getInputStream(), "UTF-8");
			BufferedReader reader = new BufferedReader(tmp);
			StringBuilder builder = new StringBuilder();
			String str;

			while ((str = reader.readLine()) != null) { // �������� ���δ����� ������ ���̹Ƿ� ���δ����� �д´�
				builder.append(str + "\n"); // View�� ǥ���ϱ� ���� ���� ������ �߰�
			}
			result = builder.toString();
		} catch (MalformedURLException e) {
		} catch (IOException e) {
		}
		System.out.println("result" + result);
		return result;
	}

	public String sendUserUpdate(JSONObject user_data) {
		// TODO Auto-generated method stub
		String result = "";
		try {
			// --------------------------
			// URL �����ϰ� �����ϱ�
			// --------------------------

			URL url = new URL("http://localhost:8080/Server/User/UpdateUserData.jsp");
			HttpURLConnection http = (HttpURLConnection) url.openConnection(); // ����
			// --------------------------
			// ���� ��� ���� - �⺻���� �����̴�
			// --------------------------
			http.setDefaultUseCaches(false);
			http.setDoInput(true); // �������� �б� ��� ����
			http.setDoOutput(true); // ������ ���� ��� ����
			http.setRequestMethod("POST"); // ���� ����� POST

			// �������� ������ <Form>���� ���� �Ѿ�� �Ͱ� ���� ������� 	ó���϶�� �� �˷��ش�
			http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8"); // --------------------------
			// ������ �� ����
			// --------------------------
			StringBuffer buffer = new StringBuffer();
			String regdata = "user_data=" + user_data;

			buffer.append(regdata); // php ������ �� ����

			OutputStreamWriter outStream = new OutputStreamWriter(http.getOutputStream(), "UTF-8");
			PrintWriter writer = new PrintWriter(outStream);
			writer.write(buffer.toString());
			writer.flush();

			// --------------------------
			// �������� ���۹ޱ�
			// --------------------------
			InputStreamReader tmp = new InputStreamReader(http.getInputStream(), "UTF-8");
			BufferedReader reader = new BufferedReader(tmp);
			StringBuilder builder = new StringBuilder();
			String str;

			while ((str = reader.readLine()) != null) { // �������� ���δ����� ������ ���̹Ƿ� ���δ����� �д´�
				builder.append(str + "\n"); // View�� ǥ���ϱ� ���� ���� ������ �߰�
			}
			result = builder.toString();
		} catch (MalformedURLException e) {
		} catch (IOException e) {
		}
		System.out.println(result);
		return result;
	}

	public String updateDayAndTime(String id) {
		String result = "";

		try {
			// --------------------------
			// URL �����ϰ� �����ϱ�
			// --------------------------
			System.out.println("1");
			URL url = new URL("http://localhost:8080/Server/Exercise/updateDayAndTime.jsp");
			System.out.println("2");
			HttpURLConnection http = (HttpURLConnection) url.openConnection(); // ����
			// --------------------------
			// ���� ��� ���� - �⺻���� �����̴�
			// --------------------------
			http.setDefaultUseCaches(false);
			http.setDoInput(true); // �������� �б� ��� ����
			http.setDoOutput(true); // ������ ���� ��� ����
			http.setRequestMethod("POST"); // ���� ����� POST
			// �������� ������ <Form>���� ���� �Ѿ�� �Ͱ� ���� ������� ó���϶�� �� �˷��ش�
			http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8"); // --------------------------
			// ������ �� ����
			// --------------------------
			StringBuffer buffer = new StringBuffer();
			String regdata = "ID=" + id;

			buffer.append(regdata); // php ������ �� ����

			OutputStreamWriter outStream = new OutputStreamWriter(http.getOutputStream(), "UTF-8");
			PrintWriter writer = new PrintWriter(outStream);
			writer.write(buffer.toString());
			writer.flush();

			// --------------------------
			// �������� ���۹ޱ�
			// --------------------------
			System.out.println("4");
			InputStreamReader tmp = new InputStreamReader(http.getInputStream(), "UTF-8");
			BufferedReader reader = new BufferedReader(tmp);
			StringBuilder builder = new StringBuilder();
			String str;
			System.out.println("5");
			while ((str = reader.readLine()) != null) { // �������� ���δ����� ������ ���̹Ƿ� ���δ����� �д´�
				System.out.println("http str " + str.toString());
				builder.append(str + "\n"); // View�� ǥ���ϱ� ���� ���� ������ �߰�
				System.out.println("builder " + builder);
			}
			result = builder.toString();
			System.out.println("http result " + result);
		} catch (MalformedURLException e) {
			System.out.println("6");
		} catch (IOException e) {
			System.out.println("7");
		}
		System.out.println("day  " + result);
		return result;
	}

	public String registUser(String values) {
		// TODO Auto-generated method stub
		String result = "";
		try {
			// --------------------------
			// URL �����ϰ� �����ϱ�
			// --------------------------

			URL url = new URL("http://localhost:8080/Server/Login/RegistUser.jsp");
			HttpURLConnection http = (HttpURLConnection) url.openConnection(); // ����
			// --------------------------
			// ���� ��� ���� - �⺻���� �����̴�
			// --------------------------
			http.setDefaultUseCaches(false);
			http.setDoInput(true); // �������� �б� ��� ����
			http.setDoOutput(true); // ������ ���� ��� ����
			http.setRequestMethod("POST"); // ���� ����� POST

			// �������� ������ <Form>���� ���� �Ѿ�� �Ͱ� ���� ������� ó���϶�� �� �˷��ش�
			http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8"); // --------------------------
			// ������ �� ����
			// --------------------------
			StringBuffer buffer = new StringBuffer();
			String regdata = "User_data=" + values;

			buffer.append(regdata); // php ������ �� ����

			OutputStreamWriter outStream = new OutputStreamWriter(http.getOutputStream(), "UTF-8");
			PrintWriter writer = new PrintWriter(outStream);
			writer.write(buffer.toString());
			writer.flush();

			// --------------------------
			// �������� ���۹ޱ�
			// --------------------------
			InputStreamReader tmp = new InputStreamReader(http.getInputStream(), "UTF-8");
			BufferedReader reader = new BufferedReader(tmp);
			StringBuilder builder = new StringBuilder();
			String str;

			while ((str = reader.readLine()) != null) { // �������� ���δ����� ������ ���̹Ƿ� ���δ����� �д´�
				builder.append(str + "\n"); // View�� ǥ���ϱ� ���� ���� ������ �߰�
			}
			result = builder.toString();
		} catch (MalformedURLException e) {
		} catch (IOException e) {
		}
		System.out.println(result);
		return result;
	}

	public String loginUser(String values) {
		// TODO Auto-generated method stub
		String result = "";
		try {
			// --------------------------
			// URL �����ϰ� �����ϱ�
			// --------------------------

			URL url = new URL("http://localhost:8080/Server/Login/Login.jsp");
			HttpURLConnection http = (HttpURLConnection) url.openConnection(); // ����
			// --------------------------
			// ���� ��� ���� - �⺻���� �����̴�
			// --------------------------
			http.setDefaultUseCaches(false);
			http.setDoInput(true); // �������� �б� ��� ����
			http.setDoOutput(true); // ������ ���� ��� ����
			http.setRequestMethod("POST"); // ���� ����� POST

			// �������� ������ <Form>���� ���� �Ѿ�� �Ͱ� ���� ������� ó���϶�� �� �˷��ش�
			http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8"); // --------------------------
			// ������ �� ����
			// --------------------------
			StringBuffer buffer = new StringBuffer();
			String regdata = "User_data=" + values;

			buffer.append(regdata); // php ������ �� ����

			OutputStreamWriter outStream = new OutputStreamWriter(http.getOutputStream(), "UTF-8");
			PrintWriter writer = new PrintWriter(outStream);
			writer.write(buffer.toString());
			writer.flush();

			// --------------------------
			// �������� ���۹ޱ�
			// --------------------------
			InputStreamReader tmp = new InputStreamReader(http.getInputStream(), "UTF-8");
			BufferedReader reader = new BufferedReader(tmp);
			StringBuilder builder = new StringBuilder();
			String str;

			while ((str = reader.readLine()) != null) { // �������� ���δ����� ������ ���̹Ƿ� ���δ����� �д´�
				builder.append(str + "\n"); // View�� ǥ���ϱ� ���� ���� ������ �߰�
			}
			result = builder.toString();
		} catch (MalformedURLException e) {
		} catch (IOException e) {
		}
		System.out.println(result);
		return result;
	}
}