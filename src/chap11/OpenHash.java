package chap11;

public class OpenHash<K, V> {
    enum Status {OCCUPIED, EMPTY, DELETED};

    static class Bucket<K, V> {
        private K key;
        private V data;
        private Status stat;

        Bucket() {
            stat = Status.EMPTY;
        }

        void set(K key, V data, Status stat) {
            this.key = key;
            this.data = data;
            this.stat = stat;
        }

        void setStat(Status stat) {
            this.stat = stat;
        }
    }


}
