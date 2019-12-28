package Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONException;

public class RequestHttpURLConnection {

    public String ServeExerciseData() throws JSONException {

        String result = "";
        try {
            //--------------------------
            //   URL �����ϰ� �����ϱ�
            //--------------------------
            URL url = new URL("http://172.16.51.53:8080/Server/Exercise/ExerciseList.jsp");
            HttpURLConnection http = (HttpURLConnection) url.openConnection();   // ����
            //--------------------------
            //   ���� ��� ���� - �⺻���� �����̴�
            //--------------------------
            http.setDefaultUseCaches(false);
            http.setDoInput(true);                         // �������� �б� ��� ����
            http.setDoOutput(true);                       // ������ ���� ��� ����
            http.setRequestMethod("POST");         // ���� ����� POST

            // �������� ������ <Form>���� ���� �Ѿ�� �Ͱ� ���� ������� ó���϶�� �� �˷��ش�
            http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");            //--------------------------

            //--------------------------
            //   �������� ���۹ޱ�
            //--------------------------
            InputStreamReader tmp = new InputStreamReader(http.getInputStream(), "UTF-8");
            BufferedReader reader = new BufferedReader(tmp);
            StringBuilder builder = new StringBuilder();
            String str;

            while ((str = reader.readLine()) != null) {       // �������� ���δ����� ������ ���̹Ƿ� ���δ����� �д´�
                builder.append(str + "\n");                     // View�� ǥ���ϱ� ���� ���� ������ �߰�
            }
            result = builder.toString();
        } catch (MalformedURLException e) {
        } catch (IOException e) {
        }
        return result; 
    } // HttpPostDate
}