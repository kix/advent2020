(ns advent2020.core)

(defn parse-input [filename]
  (->>
   (clojure.string/split (slurp filename) #"\n")
   (map #(Integer/parseInt %))))

(defn find-sum [vec sum]
  (first
    (for [a vec
          b vec
          :when (= (+ a b) sum)]
      (* a b))))

(defn find-sum* [vec sum]
  (first
    (for [a vec
          b vec
          c vec
          :when (= (+ a b c) sum)]
      (* a b c))))

(comment
  (find-sum (parse-input "input1.txt") 2020)
  (find-sum* (parse-input "input1.txt") 2020))
