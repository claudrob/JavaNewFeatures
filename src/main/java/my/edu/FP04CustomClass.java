package my.edu;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Course{
    private String name;
    private String category;
    private int reviewScore;
    private int noOfStudents;

    public Course(String name, String category, int reviewScore, int noOfStudents) {
        this.name = name;
        this.category = category;
        this.reviewScore = reviewScore;
        this.noOfStudents = noOfStudents;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getReviewScore() {
        return reviewScore;
    }

    public void setReviewScore(int reviewScore) {
        this.reviewScore = reviewScore;
    }

    public int getNoOfStudents() {
        return noOfStudents;
    }

    public void setNoOfStudents(int noOfStudents) {
        this.noOfStudents = noOfStudents;
    }

    public String toString(){
        return name + ": " + noOfStudents + ": " + reviewScore;
    }
}


public class FP04CustomClass {

    public static void main(String[] args) {
        List<Course> courses = List.of(
                new Course("Spring", "Framework", 98, 20000),
                new Course("Spring Boot", "Framework", 95, 18000),
                new Course("API", "Microservices", 97, 22000),
                new Course("Microservices", "API", 96, 25000),
                new Course("FullStack", "FullStack", 91, 14000),
                new Course("AWS", "Cloud", 92, 21000),
                new Course("Azure", "Cloud", 99, 21000),
                new Course("Docker", "Cloud", 92, 20000),
                new Course("Kubernetes", "Cloud", 91, 20000)
        );
        System.out.println("courses = " + courses);

        //allMatch, noneMatch, anyMatch

        Predicate<Course> reviewScoreGreaterThan90Predicate = createPredicateWithCutoffReviewScore(90);

        Predicate<Course> reviewScoreGreaterThan95Predicate = createPredicateWithCutoffReviewScore(95);

        Predicate<Course> reviewScoreLessThan90Predicate = course -> course.getReviewScore() < 90;


        System.out.println("Do all the courses have a review score > 90: " +
                courses.stream().allMatch(reviewScoreGreaterThan90Predicate));

        System.out.println("Do all the courses have a review score > 95: " +
                courses.stream().allMatch(reviewScoreGreaterThan95Predicate));

        System.out.println("Do all the courses have a review score > 95: Using Non Match: " +
                courses.stream().noneMatch(reviewScoreGreaterThan95Predicate));

        System.out.println("All courses < 90 " + courses.stream().noneMatch(reviewScoreLessThan90Predicate));
        System.out.println("Some courses > 90 " + courses.stream().anyMatch(reviewScoreGreaterThan95Predicate));


        Comparator<Course> comparingByNoOfStudentsIncreasing = Comparator.comparingInt(Course::getNoOfStudents);
        System.out.println("Sorted by No Students: \n" +
                courses.stream()
                        .sorted(comparingByNoOfStudentsIncreasing)
                        .collect(Collectors.toList()));

        Comparator<Course> comparingByNoOfStudentsDecreasing = Comparator.comparingInt(Course::getNoOfStudents).reversed();
        System.out.println("Sorted by No Students DECREASING: \n" +
                courses.stream()
                        .sorted(comparingByNoOfStudentsDecreasing)
                        .collect(Collectors.toList()));


        Comparator<Course> comparingByNoOfStudentsAndNoOfReviews = Comparator.comparingInt(
                Course::getNoOfStudents)
                .thenComparingInt(Course::getReviewScore)
                .reversed();

        System.out.println("Comparing No Students and no reviews: \n" +
                courses.stream().sorted(comparingByNoOfStudentsAndNoOfReviews).collect(Collectors.toList())
                );


        System.out.println("Comparing No Students and no reviews Limit to 5: \n" +
                courses.stream()
                        .sorted(comparingByNoOfStudentsAndNoOfReviews)
                        .skip(3)
                        .limit(5)
                        .collect(Collectors.toList())
                );

        System.out.println(courses);

        System.out.println("Take While: \n " + courses.stream()
                .takeWhile(course -> course.getReviewScore() >= 95)
                .collect(Collectors.toList())
        );

         System.out.println("Drop While: \n " + courses.stream()
                .dropWhile(course -> course.getReviewScore() >= 95)
                .collect(Collectors.toList())
        );


        System.out.println(courses.stream()
                 .max(comparingByNoOfStudentsAndNoOfReviews));

        System.out.println(courses.stream()
                 .min(comparingByNoOfStudentsAndNoOfReviews)
                .orElse(new Course("Kubernetes", "Cloud", 91, 20000))
        );

        System.out.println(courses.stream()
                .filter(reviewScoreLessThan90Predicate)
                .min(comparingByNoOfStudentsAndNoOfReviews)
                .orElse(new Course("Kubernetes", "Cloud", 91, 20000))
        );


        System.out.println(courses.stream()
                .filter(reviewScoreGreaterThan95Predicate)
                .findFirst()
        );

        System.out.println(courses.stream()
                .filter(reviewScoreGreaterThan95Predicate)
                .findAny()
        );

        System.out.println(courses.stream()
                .filter(reviewScoreGreaterThan95Predicate)
                .mapToInt(Course::getNoOfStudents)
                .sum()
        );

        System.out.println(courses.stream()
                .filter(reviewScoreGreaterThan95Predicate)
                .mapToInt(Course::getNoOfStudents)
                .average()
        );

        System.out.println(courses.stream()
                .filter(reviewScoreGreaterThan95Predicate)
                .mapToInt(Course::getNoOfStudents)
                .count()
        );
        System.out.println(courses.stream()
                .filter(reviewScoreGreaterThan95Predicate)
                .mapToInt(Course::getNoOfStudents)
                .min()
        );

        System.out.println(courses.stream()
                .collect(Collectors.groupingBy(Course::getCategory)));

        System.out.println(courses.stream()
                .collect(Collectors.groupingBy(Course::getCategory, Collectors.counting())));

        System.out.println(courses.stream()
                .collect(Collectors.groupingBy(Course::getCategory, Collectors.maxBy(Comparator.comparing(Course::getReviewScore)))));


        System.out.println(courses.stream()
                .collect(Collectors.groupingBy(Course::getCategory, Collectors.mapping(Course::getName, Collectors.toList()))));

        int cutoffReviewScore = 95;

        Predicate<Course> reviewScoreGreaterThan95Predicate2 = createPredicateWithCutoffReviewScore(cutoffReviewScore);

        Predicate<Course> reviewScoreGreaterThan90Predicate2 = createPredicateWithCutoffReviewScore(90);


    }

    private static Predicate<Course> createPredicateWithCutoffReviewScore(int cutoffReviewScore) {
        return course -> course.getReviewScore() > cutoffReviewScore;
    }

}
