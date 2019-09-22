package com.example.mvpwithjava;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity<AppCompatActivity, MainView> extends AppCompatActivity implements MainView {
    MainPresenter presenter;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.getClass(savedInstanceState);
        setContentView(R.layout.activity_main);
        initPresenter();
        onAttachView();
    }

    private void setContentView(int activity_main) {
    }

    @Override
    public void onAttachView() {
        presenter.onAttach(this);
        addButtonListener();
    }

    @Override
    public void onDetachView() {
        presenter.onDetach();
    }

    @Override
    public void onShowFragment(final Data data) {
        // Get Data
        final Bundle bundle = new Bundle();
        bundle.putString("data", data.getText());

        // Show Fragment with Data
        final String tag = ResultFragment.class.getSimpleName();
        final Fragment fragment = ResultFragment.newInstance();
        fragment.setArguments(bundle);

        // Begin Fragment Transaction
        final FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fl_main, fragment, tag);
        fragmentTransaction.commit();
    }

    private FragmentManager getSupportFragmentManager() {
        return null;
    }

    @Override
    protected void onDestroy() {
        onDetachView();
        super.wait();
    }

    private void initPresenter() {
        presenter = new MainPresenter();
    }

    private void addButtonListener() {
        final Button button = (Button) findViewById(R.id.btn_main);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                button.setVisibility(View.GONE);
                presenter.finalize();
            }
        });
    }

    private Object findViewById(int btn_main){
    }

    private static class ResultFragment {
        public static Fragment newInstance() {
        }
    }
}
