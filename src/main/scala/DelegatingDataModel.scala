import org.apache.mahout.cf.taste.common.Refreshable
import org.apache.mahout.cf.taste.model.DataModel

trait DelegatingDataModel extends DataModel {

    val delegate:DataModel

    def getUserIDs = delegate.getUserIDs

    def getPreferencesFromUser(id:Long) = delegate.getPreferencesFromUser(id)

    def getItemIDsFromUser(userID:Long) = delegate.getItemIDsFromUser(userID)

    def getItemIDs = delegate.getItemIDs

    def getPreferencesForItem(itemID:Long) = delegate.getPreferencesForItem(itemID)

    def getPreferenceValue(userID:Long, itemID:Long) = delegate.getPreferenceValue(userID, itemID)

    def getPreferenceTime(userID:Long, itemID:Long) = delegate.getPreferenceTime(userID, itemID)

    def getNumItems = delegate.getNumItems

    def getNumUsers =  delegate.getNumUsers

    override def getNumUsersWithPreferenceFor(itemID:Long*) = delegate.getNumUsersWithPreferenceFor(itemID:_*)

    def getNumUsersWithPreferenceFor(itemID1:Long, itemID2:Long) =  delegate.getNumUsersWithPreferenceFor(itemID1, itemID2)


    def setPreference(userID : Long , itemID:Long, value:Float) {
      throw new UnsupportedOperationException()
    }

    def removePreference(userID:Long, itemID:Long) {
      throw new UnsupportedOperationException();
    }

    def refresh(alreadyRefreshed:java.util.Collection[Refreshable]) {
      // do nothing
    }

    def hasPreferenceValues =  delegate.hasPreferenceValues

    def getMaxPreference = delegate.getMaxPreference

    def getMinPreference =  delegate.getMinPreference

    override def toString = "MyDataModel";
}