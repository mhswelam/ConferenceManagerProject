package cleanCode;

import java.awt.EventQueue;

/**
 * @author Clean Code
 * @author Polina Kud
 * Runs Conference by instantiating UI_Page.
 *
 */
public class ConferenceMain {
	
	/**
	 * Private constructor prevents main class from instantiating.
	 */
	private ConferenceMain() {
		throw new IllegalStateException();
	}

	/**
	 * Invokes UI_Page.
     * Command line arguments are ignored.
     * 
     * @param theArgs command line arguments.
	 */
	public static void main(String... theArgs) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
            	try {
					UI_Page window = new UI_Page(new Conference());
					window.start();
				} catch (Exception e) {
					e.printStackTrace();
				}
            }
        });
        Conference mycon = new Conference();
 
	}

}
