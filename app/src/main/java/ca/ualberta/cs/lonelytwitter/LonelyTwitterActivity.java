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

public class LonelyTwitterActivity extends Activity {

	private static final String FILENAME = "file.sav";
	private EditText bodyText;
	private ListView oldTweetsList;

	private ArrayList<Tweet> tweetList;
	private ArrayAdapter<Tweet> adapter;
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) { //*most essential to an activirty*/
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);

		saveButton.setOnClickListener(new View.OnClickListener() {



				public void onClick(View v){
					/*setResult(RESULT_OK);
					String text = bodyText.getText().toString();

					Tweet tweet = new ImportantTweet("test string");
					NormalTweet normalTweet = new NormalTweet("test string");
					HappyMood happymood = new HappyMood(":D");
					SadMood sadmood = new SadMood(":(");
					DepressingMood depressingmood = new DepressingMood(";(");
					try {
						if (tweet.isImportant())

							tweet.setMessage("better string");

					} catch(Exception e) {
						throw new RuntimeException();
					}*/


					setResult(RESULT_OK);
							String text = bodyText.getText().toString();
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
		super.onStart();
		loadFromFile();
		//tweetList = new ArrayList<Tweet>();
		adapter = new ArrayAdapter<Tweet>(this, R.layout.list_item ,tweetList);
		oldTweetsList.setAdapter(adapter);
	}

	private void loadFromFile() {

		try {
			FileInputStream fis = openFileInput(FILENAME);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));
			String line = in.readLine();
			Gson gson = new Gson();
//Taken from http://stackoverflow.com/questions/12384064/gson-convert-from
			//tweetList = gson.fromJson(in, ArrayList<Tweet>);
			tweetList = gson.fromJson(in, new TypeToken<ArrayList<NormalTweet>>(){}.getType());
			fis.close();
		} catch (FileNotFoundException e) {
			tweetList = new ArrayList<Tweet>();
		} catch (IOException e) {
			throw new RuntimeException();
		}

	}

	private void saveInFile() {
		try {
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