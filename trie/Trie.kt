class Trie() {
    public var fin = false;
    private var map: MutableMap<Char, Trie> = mutableMapOf();

    fun addWord(word: String) {
        var toAdd = word;
        var ctree = this;
        while(toAdd != "") {
            var ch = toAdd[0];
            toAdd = toAdd.drop(1);
            var next = ctree.map.get(ch);
            if(next == null) {
                next = Trie();
                ctree.map.set(ch, next)
            }
            ctree = next;
        }
        ctree.fin = true;
    }

    fun findWord(word: String): Trie? {
        var toFind = word;
        var ctree = this;
        while(toFind != "") {
            var ch = toFind[0];
            toFind = toFind.drop(1);
            var res = ctree.findChar(ch)
            if(res == null) return null;
            ctree = res;
        }
        return ctree;
    }

    fun findChar(ch: Char): Trie? {
        return this.map.get(ch);
    }
}