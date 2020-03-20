package kr.uk.dh.a20200320_01_profile;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;

import com.bumptech.glide.Glide;

import kr.uk.dh.a20200320_01_profile.databinding.ActivityMainBinding;

public class MainActivity extends BaseActivity {

    private static final int REQUEST_FOR_ALBUM = 1000;

    ActivityMainBinding binding = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        setupEvets();
        setValues();

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("화면 재등장","다시 나타날때마다 실행");
    }
    //

    @Override
    public void setupEvets() {
        binding.profilePicBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                갤러리에서 사진을 가져오자~!
//                안드로이다가 제공 하는 화면(갤러리) => Intent로 이동 하자.!

                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                intent.setType(MediaStore.Images.Media.CONTENT_TYPE);
                startActivityForResult(intent,REQUEST_FOR_ALBUM);
//                숫자로 했을시 먼지 모르니 이름을 부여 해서 변경
//                MediaStore < 자동완성 Content Type 자동 완성 해야함...

            }
        });
    }

    @Override
    public void setValues() {




    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_FOR_ALBUM) {
            if (resultCode == RESULT_OK) {
               if (data.getData() != null) {
                   Log.d("사진가져오기",data.getDataString().toString());
//                   제대로 작동 안함 ㅋㅋㅋ
                   Glide.with(mContext).load(data.getData()).into(binding.profileImg);
//                   Glide.with(mContext).load(R.layout.support_simple_spinner_dropdown_item ).into(binding.profileImg);
               }
            }
        }
    }
}
