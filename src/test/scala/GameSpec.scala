import com.horacio.Game
import com.horacio.Game._
import com.horacio.helpers.UserInputTest
import org.scalatest._

class GameSpec extends FlatSpec with Matchers {

  "Game" should "have tests" in {
    val usertest = UserInputTest
    assert(start(usertest) == "The animal you thought was a Dog")
  }
}
