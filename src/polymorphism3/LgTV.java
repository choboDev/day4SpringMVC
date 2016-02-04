package polymorphism3;

public class LgTV implements TV {
	private Speaker speaker;
	public LgTV() {
		System.out.println("===> LgTV(1) ��ü ����");
	}
	public LgTV(Speaker speaker) {
		System.out.println("===> LgTV(2) ��ü ����");
		this.speaker=speaker;
	}
	public void powerOn() {
		System.out.println("LgTV---���� �Ҵ�.");
	}	
	public void powerOff() {
		System.out.println("LgTV---���� ����.");
	}
	public void volumeUp() {
		speaker.volumeUp();
	}
	public void volumeDown() {
		speaker.volumeDown();
	}
	
}
