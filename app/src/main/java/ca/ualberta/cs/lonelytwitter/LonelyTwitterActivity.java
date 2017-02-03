package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import static java.io.FileDescriptor.out;

/**
 * The type Lonely twitter activity.
 * This class is the main view class of the project. <br> In this class, user interaction and file
 * manipulation is performed. All files are in the form of "json" files that ares tored
 * in Emulator's accessibile from Android Device Monitor:
 * <pre>
 *     pre-formatted text: <br>
 *         File Explorer -> data-> data -> ca.ualberta.cs.lonelytitter -> files -> file.sav.
 * </pre>
 * <code> begin <br>
 *     some pseudo code here <br>
 *  end.</code>
 *  The file name is indicated in the &nbsp; &nbsp FILENAME constant
 *  <ul>
 *      <li>item 1</li>
 *      <li>item 2</li>
 *      <li>item 3</li>
 *  </ul>
 *  <ol>
 *      <li>item 1</li>
 *      <li>item 2</li>
 *      <li>item 3</li>
 *  </ol>
 *
 *  @author Henry Truong
 *  @version 1.4.2
 *  @since 1.0
 *  </ul>
 */
public class LonelyTwitterActivity extends Activity {
	/**
	 * The file that all the tweets are saved there.
	 * The format of the file is JSON
	 * @see #loadFromFile()
	 * @see #saveInFile()
	 */
	private static final String FILENAME = "file.sav";
	private enum TweetListOrdering {DATE_ASCENDING, DATE_DESCENDING, TEXT_ASCENDING
	 , TEXT_DESCENDING};
	private EditText bodyText;
	private ListView oldTweetsList;

	private ArrayList<Tweet> tweetList;
	private ArrayAdapter<Tweet> adapter;

	/**
	 * Called when teh activity is first created
	 * @param savedInstanceState
     */
	@Override
	public void onCreate(Bundle savedInstanceState) { //*most essential to an activirty*/
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);
		/**
		 * Loads tweets from file.
		 * @throws TweetTooLongException if the tweet is too long
		 * @exception FileNotFoundExceptionExecption if the file is not created
		 */
		saveButton.setOnClickListener(new View.OnClickListener() {



				public void onClick(View v){
					/**
					 * Response for when button is clicked for save
					 */


					setResult(RESULT_OK);
					String text = bodyText.getText().toString();
					text = trimExtraSpaces(text);
					Tweet tweet = new NormalTweet(text);
					tweetList = new ArrayList<Tweet>();

					tweetList.add(tweet);
					adapter.notifyDataSetChanged();
					saveInFile();

				}

		});
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		/**
		 * This method loads tweets onStart
		 *
		 */
		super.onStart();
		loadFromFile();

		adapter = new ArrayAdapter<Tweet>(this, R.layout.list_item ,tweetList);
		oldTweetsList.setAdapter(adapter);
	}

	/**
	 * Removes extra spaces in the given string
	 * @param inputString
	 * @return string without extra spaces
     */
	private String trimExtraSpaces(String inputString){
		inputString = inputString.replaceAll("\\s+", " ");
		return inputString;
	}
	private void sortTweetListItems(TweetListOrdering ordering){
		/**
		 * Orders tweetlists empty from lab session
		 * @param ordering
		 * @orders lists
		 */

	}
	private void loadFromFile() {

		try {
			FileInputStream fis = openFileInput(FILENAME);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));
			String line = in.readLine();
			Gson gson = new Gson();
//Taken from http://stackoverflow.com/questions/12384064/gson-convert-from
			//tweetList = gson.fromJson(in, ArrayList<Tweet>);
			/**
			 * method loads the contents from file
			 * no parameters as it starts automatically
			 * @throws FileNotFoundException if the file or folder doesn't exist
 			 */
			tweetList = gson.fromJson(in, new TypeToken<ArrayList<NormalTweet>>(){}.getType());
			fis.close();
		} catch (FileNotFoundException e) {
			tweetList = new ArrayList<Tweet>();
		} catch (IOException e) {
			throw new RuntimeException();
		}

	}

	/**
	 * Saves tweet in file in JSON format.
	 * @throws FileNotFoundException if folder not exeists
	 */
	private void saveInFile() {
		try {
			/**
			 * When save button is called, method tries to save tweets to screen
			 * @throws FileNotFoundException if there is nothing to save or unable to
			 */
			FileOutputStream fos = openFileOutput(FILENAME,
					Context.MODE_PRIVATE);
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));

			Gson gson = new Gson();

			gson.toJson(tweetList, out);

			out.flush();
			fos.close();
		} catch (FileNotFoundException e) {
			throw new RuntimeException();
		} catch (IOException e) {
			throw new RuntimeException();

		}
	}
}