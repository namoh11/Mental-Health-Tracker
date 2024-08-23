package com.example.mentalhealthtracker;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.io.Serializable;

/*
Actually handles displaying the questions
 */
public class QuestionFragment extends Fragment {
    private static final String ARG_QUESTION = "question";

    private DepressionInventoryQuestion question;

    public static QuestionFragment newInstance(DepressionInventoryQuestion question) {
        QuestionFragment fragment = new QuestionFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_QUESTION, (Serializable) question); // Make sure DepressionInventoryQuestion implements Serializable or Parcelable
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            question = (DepressionInventoryQuestion) getArguments().getSerializable(ARG_QUESTION);
        }
    }

    @Override // next line actually inflates the view. hence the inflater.
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout and set up the question display
        View view = inflater.inflate(R.layout.fragment_question, container, false);

        // Example: Display the question text
        TextView questionTextView;
        questionTextView = view.findViewById(R.id.question_text);
        questionTextView.setText(question.getQuestion());

        // Set up other UI elements (e.g., radio buttons for answers)

        return view;
    }
}

