package gaarden.Project13_2

var count = 0
val lock = "MyLock"

class MyThread: Thread(){
    override fun run() {
        for (i in 1..10000){
            synchronized(lock){
                count++
            }
        }
    }
}

fun main(){
    var thread1 = MyThread()
    var thread2 = MyThread()
    thread1.start()
    thread2.start()
    thread1.join()
    thread2.join()
    println(count)
}