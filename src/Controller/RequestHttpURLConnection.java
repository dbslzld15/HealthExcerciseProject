package Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import org.json.JSONException;
import org.json.JSONObject;

public class RequestHttpURLConnection {

	public boolean checkLogin(JSONObject loginObject) {
		boolean check = false;

		try {
			try {
				URL url = new URL("http://localhost:8080/Server/Login/Login.jsp?user_id=" + loginObject.get("user_id")
						+ "&user_pw=" + loginObject.get("user_pw"));
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (MalformedURLException e) {
		} catch (IOException e) {
		}

		return check;
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
	/* ������ �Խñ� ������ �Է��ϴ� �Լ� */
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

	public String ServeMyExerciseData() throws JSONException {

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

	public String deleteMyExerciseData(String deleteExerciseName) throws JSONException {
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
			String regdata = "deleteExerciseName=" + deleteExerciseName;

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

	public String sendUserUpdate(String values) {
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

			// �������� ������ <Form>���� ���� �Ѿ�� �Ͱ� ���� ������� ó���϶�� �� �˷��ش�
			http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8"); // --------------------------
			// ������ �� ����
			// --------------------------
			StringBuffer buffer = new StringBuffer();
			String regdata = "Exercise_time=" + values;

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

	public String updateDayAndTime() {
		String result = "";

		try {
			// --------------------------
			// URL �����ϰ� �����ϱ�
			// --------------------------
			System.out.println("1");
			URL url = new URL("http://localhost:8080/Server/Exercise/updateDayAndTime.jsp?user_id=c");
			System.out.println("2");
			HttpURLConnection http = (HttpURLConnection) url.openConnection(); // ����
			// --------------------------
			// ���� ��� ���� - �⺻���� �����̴�
			// --------------------------
			System.out.println("3");
			http.setDefaultUseCaches(false);
			http.setDoInput(true); // �������� �б� ��� ����
			http.setDoOutput(true); // ������ ���� ��� ����
			http.setRequestMethod("POST"); // ���� ����� POST
			// �������� ������ <Form>���� ���� �Ѿ�� �Ͱ� ���� ������� ó���϶�� �� �˷��ش�
			http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8"); // --------------------------

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
}