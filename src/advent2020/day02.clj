(ns advent.day02)

(defn is-valid? [line]
  (let [[_ min max character password] (re-matches #"(\d+)-(\d+)\s([a-zA-Z]):\s(\w+)" line)
        count (count (filter #(= % (first character)) password))]
    (and
      (>= count (Integer/parseInt min))
      (<= count (Integer/parseInt max)))))

(defn is-valid?* [line]
  (let [[_ pmin pmax character password] (re-matches #"(\d+)-(\d+)\s([a-zA-Z]):\s(\w+)" line)]
    (not=
      (= (first character) (nth password (dec (Integer/parseInt pmin))))
      (= (first character) (nth password (dec (Integer/parseInt pmax)))))))

(comment
  (is-valid?* "1-3 a: abcde")
  (is-valid?* "1-3 b: cdefg")
  (is-valid?* "2-9 c: ccccccccc"))

(defn parse-input [filename]
  (->>
   (clojure.string/split (slurp filename) #"\n")
   (filter is-valid?*)
   count))

(comment
  (parse-input "input2.txt"))
