import org.apache.mahout.cf.taste.common.Refreshable
import org.apache.mahout.cf.taste.eval.RecommenderBuilder
import org.apache.mahout.cf.taste.impl.common.FastByIDMap
import org.apache.mahout.cf.taste.impl.eval.AverageAbsoluteDifferenceRecommenderEvaluator
import org.apache.mahout.cf.taste.impl.model.GenericDataModel
import org.apache.mahout.cf.taste.model.{PreferenceArray, DataModel}

object Application extends App {

  object builder extends RecommenderBuilder {
    override def buildRecommender(dataModel:DataModel) =  new MyRecommender(dataModel);
  }

  object model extends DelegatingDataModel {
    val users = new FastByIDMap[PreferenceArray]()
    val delegate = new GenericDataModel(users);

    override def setPreference(userID : Long , itemID:Long, value:Float) {
      throw new UnsupportedOperationException()
    }

    override def removePreference(userID:Long, itemID:Long) {
      throw new UnsupportedOperationException();
    }

    override def refresh(alreadyRefreshed:java.util.Collection[Refreshable]) {}

    override def toString = "MyDataModel";
  }

  val evaluator = new AverageAbsoluteDifferenceRecommenderEvaluator()
  val evaluation = evaluator.evaluate(builder, null, model, 0.9, 0.1);

}
