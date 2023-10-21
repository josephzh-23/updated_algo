package Array//import com.sun.net.httpserver.Request
//
//import java.io.IOException
//
//
//class Course(var id: Int, var name: String, var isPaid: Boolean)
////keep track of number of stundent Subscirbed in this course}
//typealias Id = Int
//
////
////word search problem leetcode right here
//// Place students in apart here
//class Apartment(var id: Int, var rooms: Int)
//
//data class Student(val id: Id, val name: String, val subscribedCourses: List<Course>)
//interface Repository<T> {
//    fun get(): Iterable<T>
//}
//
//fun Graph.Edges_question.String.main() {
//    var course1 = Course(0, "english", true)
//    var course2 = Course(0, "math", true)
//    var course3 = Course(0, "biology", false)
//
//
//    var apart1 = Apartment(0, int, )
//    var apart2 = Course(1, "math", true)
//    var apart3 = Course(2, "biology", false)
//    var courseList = listOf(course1, course2)
//    var courseList2 = listOf(course2, course3)
//    var student1 = Student(0, "joseph", courseList)
//    var student2 = Student(0, "joseph", courseList2)
//    var students = listOf<Student>(student1, student2)
//    University(object : Repository<Student> {
//
//        override fun get(): Iterable<Student> {
//            val studentList = mutableListOf<Student>()
//            val iter: Iterator<*> = students.iterator()
//            while (iter.hasNext()) {
//                studentList.add(iter.next() as Student)
//            }
//            return students
//        }
//    })
//
//    listOf(student1, student2,
//
//
//// Students want to be placed in courses here
//// If there is room then keep going otherwise quit
//
//
//internal class University(private val repo: Repository<Student>) {
//    var students: Iterable<Student> = repo.get()
//    val data: HashMap<Course, MutableList<Student>> = HashMap()
//    var results: HashMap<Course, Int> = HashMap()
//
//    init {
//        // get the students from the repository
//        students.forEach { student ->
//            student.subscribedCourses.forEach { course ->
//
//                data.putIfAbsent(course, mutableListOf())
//                data[course]?.add(student)
//            }
//
//        }
//    }
//
//
//
//    //required method
//    fun getPaidCoursesWithTheNumbersOfSubscribedStudents(courseCount: Int): HashMap<Course, Int> {
//        var courseCount = courseCount
//
//        for (entry in data.entries) {
//            val course = entry.key
//            if (courseCount == 0) {
//                break
//            }
//            if (course.isPaid) {
//                results.run {
//                    put(course, getOrDefault(course, 0) + 1)
//                }
//                courseCount--
//            }
//        }
//        return results
//    }
//}
//
//
//
//
//
//
