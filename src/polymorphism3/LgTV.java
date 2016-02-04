package polymorphism3;

public class LgTV implements TV {
	private Speaker speaker;
	public LgTV() {
		System.out.println("===> LgTV(1) 按眉 积己");
	}
	public LgTV(Speaker speaker) {
		System.out.println("===> LgTV(2) 按眉 积己");
		this.speaker=speaker;
	}
	public void powerOn() {
		System.out.println("LgTV---傈盔 囊促.");
	}	
	public void powerOff() {
		System.out.println("LgTV---傈盔 馋促.");
	}
	public void volumeUp() {
		speaker.volumeUp();
	}
	public void volumeDown() {
		speaker.volumeDown();
	}
	
}
