package net.skhu.e201432014;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.EditText;

public class StudentAddFragment extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final MainActivity activity = (MainActivity)getActivity();
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle("등록");

        final View rootView = activity.getLayoutInflater().inflate(R.layout.student_add, null);

        final EditText studentNumber = (EditText)rootView.findViewById(R.id.editText_studentNumber2);
        final EditText name = (EditText)rootView.findViewById(R.id.editText_name2);

        builder.setView(rootView);

        builder.setPositiveButton("저장", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                activity.arrayList.add(new StudentData(studentNumber.getText().toString(), name.getText().toString()));
                activity.recyclerAdapter.notifyDataSetChanged();
            } // onClick 메소드의 끝
        });
        // 대화상자에 '저장' 버튼을 추가하는 코드의 끝

        builder.setNegativeButton("취소", null); // 대화상자에 '취소' 버튼을 추가하기
        AlertDialog dialog = builder.create(); // 대화상자 객체 생성하기
        return dialog; // 생성된 대화상자 객체 리턴
    }
}
