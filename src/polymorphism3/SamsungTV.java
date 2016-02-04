package polymorphism3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("tv")
public class SamsungTV implements TV {
	@Autowired
	private Speaker speaker;
	
	public SamsungTV() {
		System.out.println("===> SamsungTV(1) 객체 생성");
	}
	public SamsungTV(Speaker speaker) {
		System.out.println("===> SamsungTV(2) 객체 생성");
		this.speaker=speaker;
	}
	
	public void setSpeaker(Speaker speaker) {
		System.out.println("===> setSpeaker 메서드 호출");
		this.speaker = speaker;
	}
	public void powerOn() {
		System.out.println("SamsungTV---전원 켠다.");
	}	
	public void powerOff() {
		System.out.println("SamsungTV---전원 끈다.");
	}
	public void volumeUp() {
		speaker.volumeUp();
	}
	public void volumeDown() {
		speaker.volumeDown();
	}
	
}
