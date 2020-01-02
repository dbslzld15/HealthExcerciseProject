package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

import org.json.JSONException;
import org.json.JSONObject;

import View.HealthFrame;

public class ExerciseStartController {
	private HealthFrame myFrame;
	private TimerThread timerThread;
	private SetTimerThread setTimerThread;
	private int curExercise = 0;
	private int secs,sec,hour,min;
	public boolean stop = true;
	public boolean work = false;
	private RequestHttpURLConnection rHUC;

	public ExerciseStartController(HealthFrame myFrame) {
		this.myFrame = myFrame;
		myFrame.setExerciseStartController(this);
		myFrame.geteSView().getStartTimerBtn().addActionListener(new BtnActionListener());
		myFrame.geteSView().getStopTimerBtn().addActionListener(new BtnActionListener());
		rHUC = new RequestHttpURLConnection();
	}

	class BtnActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == myFrame.geteSView().getStartTimerBtn()) {
				if (stop == true) {
					work = true;
					stop = false;
					timerThread = new TimerThread(myFrame.geteSView().getExerciseTimeNumLb());
					timerThread.start();
					setTimerThread = new SetTimerThread(myFrame.geteSView().getSetTimeLb(),
							myFrame.geteSView().getSetTimeNumLb());
					setTimerThread.start();
				}

				else {
					work = true;
				}
			}
			if (e.getSource() == myFrame.geteSView().getStopTimerBtn()) {

				work = false;
			}
		}

	}

	class TimerThread extends Thread {
		JLabel timerLabel = null;
		int y = 1;

		public TimerThread(JLabel timerLabel) {
			this.timerLabel = timerLabel;

		}

		public void run() {
			while (!stop) {
				if (work) {
		               secs=y;
		               sec=secs%60;
		               min=secs/60 %60;
		               hour=secs/3600;
		               timerLabel.setText(hour+"�� "+min+"�� "+sec+" ��");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					y++;
				} else {
					Thread.yield();
				}
			}

		}
	}

	class SetTimerThread extends Thread {
		JLabel setTimerLabel = null;
		JLabel setTextLabel = null;
		int cnt = 6; // ī��Ʈ ����
		int y = 1; // �ð� �ؽ�Ʈ ��
		int curset = 0; // ���� ��Ʈ��

		public SetTimerThread(JLabel setTextLabel, JLabel setTimerLabel) {
			this.setTimerLabel = setTimerLabel;
			this.setTextLabel = setTextLabel;
		}

		public void run() {
			while (!stop) {
				if (work) {
					if (cnt <= 5) {
						setTimerLabel.setText("" + y);
					} else if (cnt <= 10) {
						if (cnt == 6) {
							if (curset == myFrame.getSet()) // ���� ��� ��Ʈ ���� ��� ä���� ���
							{
								myFrame.geteSView().getMyExerciseListList().setValueAt("��Ϸ�", curExercise, 1);
								curset = 1;
								if (curExercise == myFrame.geteSView().getMyExerciseListList().getRowCount() - 1) {
									setTextLabel.setText("� ����!");
									// � ���� �� user �� ��ð� �� � �� �� UPDATE
									JSONObject jsonObject = new JSONObject();
									try {
										jsonObject.put("user_id", myFrame.id);
										jsonObject.put("user_time",
												myFrame.geteSController().secs);
									} catch (JSONException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}

									rHUC.sendUserUpdate(jsonObject);
									stop = true;
									break;
								} else {
									curExercise++; // ���� ����� ����
									System.out.println(curExercise);
								}
							} else {
								curset++;
								myFrame.geteSView().getCurSetNumLb().setText(Integer.toString(curset));
							}
							setTextLabel.setText("� �غ���");
							y = 5;
						}
						setTimerLabel.setText("" + y);
					} else {
						y = 5;
						cnt = 0;
						setTimerLabel.setText("" + y);
						myFrame.geteSView().getMyExerciseListList().setValueAt("���", curExercise, 1);
						setTextLabel.setText("� ��!");
						myFrame.geteSView().getCurSetNumLb().setText("" + curset);
					}
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					y--;
					cnt++;
					if(myFrame.getTime()==min)
					{
						stop = true;
					}

				} else {
					Thread.yield();
				}
			} // while

		}
	}
}