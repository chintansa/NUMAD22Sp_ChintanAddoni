package edu.neu.madcourse.numad22sp_chintanaddoni;

public class Card implements LinkListener {

        private final String url;

        public Card(String url) {
            this.url = url;
        }

        public String getUrl() {
            return url;
        }

        @Override
        public void onItemClick(int position) {

        }
}
