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
	
	

	class RegisterActionListener implements ActionListener{ //��� ��ư Ŭ����

		@Override
		public void actionPerformed(ActionEvent e) {
			
			myFrame.getmPView().getListModel().addElement(additem);
		}
	}
	
	class ExButtonActionListener implements ActionListener{ //��׸� ��ư Ŭ����
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

			JButton btn = (JButton)e.getSource();
			additem="��ư�� �������ִ� �����̸� btn.�޼ҵ� Ȱ�� ����";
			myFrame.gethLView().getExplainArea().setText("db�� �ִ� � �� ���� ������ ����");
		}
		
	}
	
	class FirstBoxItemListener implements ItemListener{ //ù��° �޺��ڽ� ������

		@Override
		public void itemStateChanged(ItemEvent e) {
			// TODO Auto-generated method stub
		
			ArrayList<String> array = new ArrayList<>();
			Iterator<String> iter;
			if(myFrame.gethLView().getFirstBox().getSelectedItem().equals("��ü����"))
			{
				myFrame.gethLView().getSecondBox().removeAllItems();
				array.add("��ü����");
				iter = array.iterator();
				while(iter.hasNext())
				{
					myFrame.gethLView().getSecondBox().addItem(iter.next());
				}
				
			}
			else if(myFrame.gethLView().getFirstBox().getSelectedItem().equals("���"))
			{
				myFrame.gethLView().getSecondBox().removeAllItems();
				array.add("��ü����");
				array.add("���� �ﰢ��");
				array.add("�ĸ� �ﰢ��");
				array.add("���� �ﰢ��");
				iter = array.iterator();
				while(iter.hasNext())
				{
					myFrame.gethLView().getSecondBox().addItem(iter.next());
				}
				
			}
			else if(myFrame.gethLView().getFirstBox().getSelectedItem().equals("����"))
			{
				myFrame.gethLView().getSecondBox().removeAllItems();
				array.add("��ü����");
				array.add("�����δ�");
				array.add("����");
				array.add("���� �δ�");
				iter = array.iterator();
				while(iter.hasNext())
				{
					myFrame.gethLView().getSecondBox().addItem(iter.next());
				}
				
			}
			else if(myFrame.gethLView().getFirstBox().getSelectedItem().equals("�㸮"))
			{
				myFrame.gethLView().getSecondBox().removeAllItems();
				array.add("��ü����");
				array.add("�㸮 ������");
				array.add("��ũ");
				array.add("����");
				iter = array.iterator();
				while(iter.hasNext())
				{
					myFrame.gethLView().getSecondBox().addItem(iter.next());
				}
				
			}
			
		}
		
	}
	
	
	
	class InButtonActionListener implements ActionListener{ //�Է� ��ư �����ÿ�

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
	                //���� �ֱٿ� ��� �Խñ��� �� ���� �ߵ��� ��

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
			
			
			if(myFrame.gethLView().getFirstBox().getSelectedIndex()==0) //��ü����
			{
				 if(myFrame.gethLView().getSecondBox().getSelectedIndex()==0)
				 {
					 myFrame.gethLView().getExButton()[0].setText(arrayName.get(1)); //�������� ������ 
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
			if(myFrame.gethLView().getFirstBox().getSelectedIndex()==1) //���
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
			if(myFrame.gethLView().getFirstBox().getSelectedIndex()==2) //����
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
			if(myFrame.gethLView().getFirstBox().getSelectedIndex()==3) //�㸮
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
