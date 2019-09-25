
import commands.MediaKeys;

public class mediaControl
{
	public static void main(String[] argv)
	{
		voce.SpeechInterface.init("lib/", false, true,
			"lib/gram/", "digits");

		System.out.println("\nThis is a audio media speech control.\n"
			+ "Say 'play', 'pause' or 'one' to play/pause the music. \n"
			+ "Say 'next' or 'two' for next music. \n"
			+ "Say 'mute' or 'three' to mute music. \n"
			+ "Say 'volume' or 'four' for volume up. \n"
			+ "Speak 'exit' or 'nine' to exit the program.");


		boolean quit = false;
		while (!quit)
		{
			// Normally, applications would do application-specific things 
			// here.  For this sample, we'll just sleep for a little bit.
			try
			{
				Thread.sleep(200);
			}
			catch (InterruptedException e)
			{
			}


			while (voce.SpeechInterface.getRecognizerQueueSize() > 0)
			{
				String s = voce.SpeechInterface.popRecognizedString();

				switch (s){
					case "play":
					case "stop":
					case "one":{
					    MediaKeys.songPlayPause();
						break;
					}
					case "next":
					case "two":{
						MediaKeys.songNext();
						break;
					}
					case "mute":
					case "three":{
						MediaKeys.volumeMute();
						break;
					}
					case "four":{
						MediaKeys.volumeUp();
						break;
					}
					case "exit":
					case "nine":{
						quit = true;
						break;
					}

				}


				System.out.println("You said: " + s);
				//voce.SpeechInterface.synthesize(s);
			}
		}

		voce.SpeechInterface.destroy();
		System.exit(0);
	}
}

