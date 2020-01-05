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
		               timerLabel.setText(hour+"시 "+min+"분 "+sec+" 초");
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
		int cnt = 6; // 카운트 변수
		int y = 1; // 시간 텍스트 값
		int curset = 0; // 현재 세트수

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
							if (curset == myFrame.getSet()) // 현재 운동의 세트 수를 모두 채웠을 경우
							{
								myFrame.geteSView().getMyExerciseListList().setValueAt("운동완료", curExercise, 1);
								curset = 1;
								if (curExercise == myFrame.geteSView().getMyExerciseListList().getRowCount() - 1) {
									setTextLabel.setText("운동 종료!");
									// 운동 종료 시 user 총 운동시간 및 운동 일 수 UPDATE
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
									curExercise=0;
									stop = true;
									break;
								} else {
									curExercise++; // 다음 운동으로 변경
									System.out.println(curExercise);
								}
							} else {
								curset++;
								myFrame.geteSView().getCurSetNumLb().setText(Integer.toString(curset));
							}
							setTextLabel.setText("운동 준비중");
							y = 5;
						}
						setTimerLabel.setText("" + y);
					} else {
						y = 5;
						cnt = 0;
						setTimerLabel.setText("" + y);
						myFrame.geteSView().getMyExerciseListList().setValueAt("운동중", curExercise, 1);
						setTextLabel.setText("운동 중!");
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
						curExercise=0;
						stop = true;
					}

				} else {
					Thread.yield();
				}
			} // while

		}
	}
	public int getCurExercise() {
		return curExercise;
	}

	public void setCurExercise(int curExercise) {
		this.curExercise = curExercise;
	}

}