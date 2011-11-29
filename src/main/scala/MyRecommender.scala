import org.apache.mahout.cf.taste.common.Refreshable
import org.apache.mahout.cf.taste.impl.recommender.slopeone.SlopeOneRecommender
import org.apache.mahout.cf.taste.model.DataModel
import org.apache.mahout.cf.taste.recommender.{IDRescorer, RecommendedItem, Recommender}

class MyRecommender(dataModel:DataModel) extends Recommender{
  val recommender = new SlopeOneRecommender(dataModel)

  override def recommend(userID:Long, howMany:Int) = recommender.recommend(userID, howMany)

  override def recommend(userID:Long, howMany:Int, rescorer:IDRescorer) = recommender.recommend(userID, howMany, rescorer)


  override def estimatePreference(userID:Long, itemID:Long) = recommender.estimatePreference(userID, itemID)

  override def setPreference(userID:Long, itemID:Long, value:Float) {
    recommender.setPreference(userID, itemID, value)
  }

  override def removePreference(userID:Long, itemID:Long){
    recommender.removePreference(userID, itemID)
  }

  override def getDataModel() = recommender.getDataModel()

  override def refresh(alreadyRefreshed:java.util.Collection[Refreshable]) {
    recommender.refresh(alreadyRefreshed)
  }

  override def toString() = "BookCrossingRecommender[recommender:" + recommender + ']'
}