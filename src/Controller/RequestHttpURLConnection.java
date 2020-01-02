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
			// URL 설정하고 접속하기
			// --------------------------

			URL url = new URL("http://localhost:8080/Server/Exercise/ExerciseList.jsp");

			HttpURLConnection http = (HttpURLConnection) url.openConnection(); // 접속
			// --------------------------
			// 전송 모드 설정 - 기본적인 설정이다
			// --------------------------
			http.setDefaultUseCaches(false);
			http.setDoInput(true); // 서버에서 읽기 모드 지정
			http.setDoOutput(true); // 서버로 쓰기 모드 지정
			http.setRequestMethod("POST"); // 전송 방식은 POST

			// 서버에게 웹에서 <Form>으로 값이 넘어온 것과 같은 방식으로 처리하라는 걸 알려준다
			http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8"); // --------------------------

			// --------------------------
			// 서버에서 전송받기
			// --------------------------
			InputStreamReader tmp = new InputStreamReader(http.getInputStream(), "UTF-8");
			BufferedReader reader = new BufferedReader(tmp);
			StringBuilder builder = new StringBuilder();
			String str;

			while ((str = reader.readLine()) != null) { // 서버에서 라인단위로 보내줄 것이므로 라인단위로 읽는다
				builder.append(str + "\n"); // View에 표시하기 위해 라인 구분자 추가
			}
			result = builder.toString();
		} catch (MalformedURLException e) {
		} catch (IOException e) {
		}
		return result;
	} // HttpPostDate

	// ----------------------------------
	/* 서버에 게시글 정보를 입력하는 함수 */
	// ----------------------------------
	public String sendMyExerciseInsert(String values) throws JSONException {

		String result = "";
		try {
			// --------------------------
			// URL 설정하고 접속하기
			// --------------------------

			URL url = new URL("http://localhost:8080/Server/Exercise/InsertMyExerciseList.jsp");
			HttpURLConnection http = (HttpURLConnection) url.openConnection(); // 접속
			// --------------------------
			// 전송 모드 설정 - 기본적인 설정이다
			// --------------------------
			http.setDefaultUseCaches(false);
			http.setDoInput(true); // 서버에서 읽기 모드 지정
			http.setDoOutput(true); // 서버로 쓰기 모드 지정
			http.setRequestMethod("POST"); // 전송 방식은 POST

			// 서버에게 웹에서 <Form>으로 값이 넘어온 것과 같은 방식으로 처리하라는 걸 알려준다
			http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8"); // --------------------------
			// 서버로 값 전송
			// --------------------------
			StringBuffer buffer = new StringBuffer();
			String regdata = "My_exercise_data=" + values;

			buffer.append(regdata); // php 변수에 값 대입

			OutputStreamWriter outStream = new OutputStreamWriter(http.getOutputStream(), "UTF-8");
			PrintWriter writer = new PrintWriter(outStream);
			writer.write(buffer.toString());
			writer.flush();

			// --------------------------
			// 서버에서 전송받기
			// --------------------------
			InputStreamReader tmp = new InputStreamReader(http.getInputStream(), "UTF-8");
			BufferedReader reader = new BufferedReader(tmp);
			StringBuilder builder = new StringBuilder();
			String str;

			while ((str = reader.readLine()) != null) { // 서버에서 라인단위로 보내줄 것이므로 라인단위로 읽는다
				builder.append(str + "\n"); // View에 표시하기 위해 라인 구분자 추가
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
			// URL 설정하고 접속하기
			// --------------------------
			URL url = new URL("http://localhost:8080/Server/Exercise/myExerciseList.jsp");
			HttpURLConnection http = (HttpURLConnection) url.openConnection(); // 접속
			// --------------------------
			// 전송 모드 설정 - 기본적인 설정이다
			// --------------------------
			http.setDefaultUseCaches(false);
			http.setDoInput(true); // 서버에서 읽기 모드 지정
			http.setDoOutput(true); // 서버로 쓰기 모드 지정
			http.setRequestMethod("POST"); // 전송 방식은 POST
			// 서버에게 웹에서 <Form>으로 값이 넘어온 것과 같은 방식으로 처리하라는 걸 알려준다
			http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8"); // --------------------------

			// --------------------------
			// 서버에서 전송받기
			// --------------------------
			InputStreamReader tmp = new InputStreamReader(http.getInputStream(), "UTF-8");
			BufferedReader reader = new BufferedReader(tmp);
			StringBuilder builder = new StringBuilder();
			String str;

			while ((str = reader.readLine()) != null) { // 서버에서 라인단위로 보내줄 것이므로 라인단위로 읽는다
				builder.append(str + "\n"); // View에 표시하기 위해 라인 구분자 추가
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
			// URL 설정하고 접속하기
			// --------------------------
			URL url = new URL("http://localhost:8080/Server/Exercise/DeleteExerciseList.jsp");
			HttpURLConnection http = (HttpURLConnection) url.openConnection(); // 접속
			// --------------------------
			// 전송 모드 설정 - 기본적인 설정이다
			// --------------------------
			http.setDefaultUseCaches(false);
			http.setDoInput(true); // 서버에서 읽기 모드 지정
			http.setDoOutput(true); // 서버로 쓰기 모드 지정
			http.setRequestMethod("POST"); // 전송 방식은 POST
			// 서버에게 웹에서 <Form>으로 값이 넘어온 것과 같은 방식으로 처리하라는 걸 알려준다
			http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8"); // --------------------------
			// 서버로 값 전송
			// --------------------------
			StringBuffer buffer = new StringBuffer();
			String regdata = "deleteExerciseName=" + deleteExerciseName;

			buffer.append(regdata); // php 변수에 값 대입

			OutputStreamWriter outStream = new OutputStreamWriter(http.getOutputStream(), "UTF-8");
			PrintWriter writer = new PrintWriter(outStream);
			writer.write(buffer.toString());
			writer.flush();

			// --------------------------
			// 서버에서 전송받기
			// --------------------------
			InputStreamReader tmp = new InputStreamReader(http.getInputStream(), "UTF-8");
			BufferedReader reader = new BufferedReader(tmp);
			StringBuilder builder = new StringBuilder();
			String str;

			while ((str = reader.readLine()) != null) { // 서버에서 라인단위로 보내줄 것이므로 라인단위로 읽는다
				builder.append(str + "\n"); // View에 표시하기 위해 라인 구분자 추가
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
			// URL 설정하고 접속하기
			// --------------------------

			URL url = new URL("http://localhost:8080/Server/User/UpdateUserData.jsp");
			HttpURLConnection http = (HttpURLConnection) url.openConnection(); // 접속
			// --------------------------
			// 전송 모드 설정 - 기본적인 설정이다
			// --------------------------
			http.setDefaultUseCaches(false);
			http.setDoInput(true); // 서버에서 읽기 모드 지정
			http.setDoOutput(true); // 서버로 쓰기 모드 지정
			http.setRequestMethod("POST"); // 전송 방식은 POST

			// 서버에게 웹에서 <Form>으로 값이 넘어온 것과 같은 방식으로 처리하라는 걸 알려준다
			http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8"); // --------------------------
			// 서버로 값 전송
			// --------------------------
			StringBuffer buffer = new StringBuffer();
			String regdata = "Exercise_time=" + values;

			buffer.append(regdata); // php 변수에 값 대입

			OutputStreamWriter outStream = new OutputStreamWriter(http.getOutputStream(), "UTF-8");
			PrintWriter writer = new PrintWriter(outStream);
			writer.write(buffer.toString());
			writer.flush();

			// --------------------------
			// 서버에서 전송받기
			// --------------------------
			InputStreamReader tmp = new InputStreamReader(http.getInputStream(), "UTF-8");
			BufferedReader reader = new BufferedReader(tmp);
			StringBuilder builder = new StringBuilder();
			String str;

			while ((str = reader.readLine()) != null) { // 서버에서 라인단위로 보내줄 것이므로 라인단위로 읽는다
				builder.append(str + "\n"); // View에 표시하기 위해 라인 구분자 추가
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
			// URL 설정하고 접속하기
			// --------------------------
			System.out.println("1");
			URL url = new URL("http://localhost:8080/Server/Exercise/updateDayAndTime.jsp?user_id=c");
			System.out.println("2");
			HttpURLConnection http = (HttpURLConnection) url.openConnection(); // 접속
			// --------------------------
			// 전송 모드 설정 - 기본적인 설정이다
			// --------------------------
			System.out.println("3");
			http.setDefaultUseCaches(false);
			http.setDoInput(true); // 서버에서 읽기 모드 지정
			http.setDoOutput(true); // 서버로 쓰기 모드 지정
			http.setRequestMethod("POST"); // 전송 방식은 POST
			// 서버에게 웹에서 <Form>으로 값이 넘어온 것과 같은 방식으로 처리하라는 걸 알려준다
			http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8"); // --------------------------

			// --------------------------
			// 서버에서 전송받기
			// --------------------------
			System.out.println("4");
			InputStreamReader tmp = new InputStreamReader(http.getInputStream(), "UTF-8");
			BufferedReader reader = new BufferedReader(tmp);
			StringBuilder builder = new StringBuilder();
			String str;
			System.out.println("5");
			while ((str = reader.readLine()) != null) { // 서버에서 라인단위로 보내줄 것이므로 라인단위로 읽는다
				System.out.println("http str " + str.toString());
				builder.append(str + "\n"); // View에 표시하기 위해 라인 구분자 추가
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