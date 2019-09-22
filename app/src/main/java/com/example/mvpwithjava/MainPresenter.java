package com.example.mvpwithjava;

public class MainPresenter {
    public <AppCompatActivity, MainView> void onAttach(MainActivity<AppCompatActivity,MainView> appCompatActivityMainViewMainActivity) {
    }

    public void onDetach() {
    }

    public class MainPresenter implements Data.Presenter {
        private MainView mView;

        @Override
        public void onAttach(final MainView view) {
            mView = view;
        }

        @Override
        public void onDetach() {
            mView = null;
        }

        public void showFragment() {
            // Set Data
            final Data data = new Data();
            data.setText("Hello from Data!");

            // Show Fragment with Data
            mView.finalize(data);
        }

        private class MainView {
        }
    }
