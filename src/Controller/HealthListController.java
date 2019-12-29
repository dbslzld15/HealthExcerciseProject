package Controller;

import java.awt.event.*;
import java.util.*;
import javax.swing.*;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import View.HealthFrame;

public class HealthListController {

	private HealthFrame myFrame;

	private RequestHttpURLConnection urlConnection;
	private String additem="12323121";
	private JSONArray exerciseJSONArray;
	private ArrayList<String> arrayNo;
	private ArrayList<String> arrayName;
	private ArrayList<String> arrayKind;
	private ArrayList<String> arrayKindDetail;
	private String result;
	private DefaultListModel addModel;
	private String selectedString;
	private ActionListener FirstBoxItemListener;
	private ActionListener SecondBoxActionListener;
	private ActionListener InButtonActionListener;
	private ActionListener ExButtonActionListener;
	
	public HealthListController(HealthFrame myFrame) {
		this.myFrame = myFrame;
		myFrame.setHealthListController(this);
		addHeathListListener();
		urlConnection = new RequestHttpURLConnection();
		arrayNo = new ArrayList<String>();
		arrayName = new ArrayList<String>();
		arrayKind = new ArrayList<String>();
		arrayKindDetail = new ArrayList<String>();
		
	}
	

	public void addHeathListListener() {
		myFrame.gethLView().getFirstBox().addItemListener(new FirstBoxItemListener());
		myFrame.gethLView().getInButton().addActionListener(new InButtonActionListener());
		for(int i=0;i<9;i++)
		{
			myFrame.gethLView().getExButton()[i].addActionListener(new ExButtonActionListener());
		}
		myFrame.gethLView().getRegisterButton().addActionListener(new RegisterActionListener());
		
	}
	
	

	class RegisterActionListener implements ActionListener{ //등록 버튼 클릭시

		@Override
		public void actionPerformed(ActionEvent e) {
			
			myFrame.getmPView().getListModel().addElement(additem);
		}
	}
	
	class ExButtonActionListener implements ActionListener{ //운동그림 버튼 클릭시
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

			JButton btn = (JButton)e.getSource();
			additem="버튼이 가지고있는 고유이름 btn.메소드 활용 예정";
			myFrame.gethLView().getExplainArea().setText("db에 있는 운동 상세 설명 가져올 예정");
		}
		
	}
	
	class FirstBoxItemListener implements ItemListener{ //첫번째 콤보박스 리스너

		@Override
		public void itemStateChanged(ItemEvent e) {
			// TODO Auto-generated method stub
		
			ArrayList<String> array = new ArrayList<>();
			Iterator<String> iter;
			if(myFrame.gethLView().getFirstBox().getSelectedItem().equals("전체보기"))
			{
				myFrame.gethLView().getSecondBox().removeAllItems();
				array.add("전체보기");
				iter = array.iterator();
				while(iter.hasNext())
				{
					myFrame.gethLView().getSecondBox().addItem(iter.next());
				}
				
			}
			else if(myFrame.gethLView().getFirstBox().getSelectedItem().equals("어깨"))
			{
				myFrame.gethLView().getSecondBox().removeAllItems();
				array.add("전체보기");
				array.add("전면 삼각근");
				array.add("후면 삼각근");
				array.add("측면 삼각근");
				iter = array.iterator();
				while(iter.hasNext())
				{
					myFrame.gethLView().getSecondBox().addItem(iter.next());
				}
				
			}
			else if(myFrame.gethLView().getFirstBox().getSelectedItem().equals("무릎"))
			{
				myFrame.gethLView().getSecondBox().removeAllItems();
				array.add("전체보기");
				array.add("십자인대");
				array.add("연골");
				array.add("측부 인대");
				iter = array.iterator();
				while(iter.hasNext())
				{
					myFrame.gethLView().getSecondBox().addItem(iter.next());
				}
				
			}
			else if(myFrame.gethLView().getFirstBox().getSelectedItem().equals("허리"))
			{
				myFrame.gethLView().getSecondBox().removeAllItems();
				array.add("전체보기");
				array.add("허리 측만증");
				array.add("디스크");
				array.add("요추");
				iter = array.iterator();
				while(iter.hasNext())
				{
					myFrame.gethLView().getSecondBox().addItem(iter.next());
				}
				
			}
			
		}
		
	}
	
	
	
	class InButtonActionListener implements ActionListener{ //입력 버튼 누를시에

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

			try {
				result = urlConnection.ServeExerciseData();

				if (result != "") {
	                try {
	                    exerciseJSONArray = new JSONArray(result);
	                } catch (JSONException e1) {
	                    //TODO Auto-generated catch block
	                    e1.printStackTrace();
	                }
	                //제일 최근에 담긴 게시글이 맨 위에 뜨도록 함

	                for (int i = exerciseJSONArray.length() - 1; i >= 0; i--) {
	                    try {
	                        JSONObject jsonObject = exerciseJSONArray.getJSONObject(i);
	                        // Pulling items from the array
	                        arrayNo.add(jsonObject.getString("no"));
	                        arrayName.add(jsonObject.getString("name"));
	                        //arrayDetail.add(jsonObject.getString("detail"));
	                        arrayKind.add(jsonObject.getString("kind"));
	                        arrayKindDetail.add(jsonObject.getString("kind_detail"));

	                    } catch (JSONException e1) {
	                        e1.printStackTrace();
	                    }
	                }
				}
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			if(myFrame.gethLView().getFirstBox().getSelectedIndex()==0) //전체보기
			{
				 if(myFrame.gethLView().getSecondBox().getSelectedIndex()==0)
				 {
					 myFrame.gethLView().getExButton()[0].setText(arrayName.get(1)); //서버에서 가져온 
				 }
				 if(myFrame.gethLView().getSecondBox().getSelectedIndex()==1)
				 {
					 
				 }
				 if(myFrame.gethLView().getSecondBox().getSelectedIndex()==2)
				 {
					 
				 }
				 if(myFrame.gethLView().getSecondBox().getSelectedIndex()==3)
				 {
					 
				 }
				
			}
			if(myFrame.gethLView().getFirstBox().getSelectedIndex()==1) //어깨
			{
				 if(myFrame.gethLView().getSecondBox().getSelectedIndex()==0)
				 {
					 
				 }
				 if(myFrame.gethLView().getSecondBox().getSelectedIndex()==1)
				 {
					 
				 }
				 if(myFrame.gethLView().getSecondBox().getSelectedIndex()==2)
				 {
					 
				 }
				 if(myFrame.gethLView().getSecondBox().getSelectedIndex()==3)
				 {
					 
				 }
				
			}
			if(myFrame.gethLView().getFirstBox().getSelectedIndex()==2) //무릎
			{
				 if(myFrame.gethLView().getSecondBox().getSelectedIndex()==0)
				 {
					 
				 }
				 if(myFrame.gethLView().getSecondBox().getSelectedIndex()==1)
				 {
					 
				 }
				 if(myFrame.gethLView().getSecondBox().getSelectedIndex()==2)
				 {
					 
				 }
				 if(myFrame.gethLView().getSecondBox().getSelectedIndex()==3)
				 {
					 
				 }
				
			}
			if(myFrame.gethLView().getFirstBox().getSelectedIndex()==3) //허리
			{
				 if(myFrame.gethLView().getSecondBox().getSelectedIndex()==0)
				 {
					 
				 }
				 if(myFrame.gethLView().getSecondBox().getSelectedIndex()==1)
				 {
					 
				 }
				 if(myFrame.gethLView().getSecondBox().getSelectedIndex()==2)
				 {
					 
				 }
				 if(myFrame.gethLView().getSecondBox().getSelectedIndex()==3)
				 {
					 
				 }
				
			}
			
		}

	}

}
