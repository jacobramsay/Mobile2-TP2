package ca.csf.mobile2.tp2.question

import org.parceler.Parcel
import org.parceler.ParcelConstructor
import java.util.*

@Parcel(Parcel.Serialization.BEAN)
data class QuestionModel(
    var id: String = "",
    var text: String = "",
    var choice1: String = "",
    var choice2: String = "",
    var nbChoice1: Int = 0,
    var nbChoice2: Int = 0
) {
    public fun getChoice1Result() : String{
        var choice1Result : Int = 0
        if(nbChoice2==0){
            if(nbChoice1 == 0){
                return "$choice1Result %"
            }else{
                choice1Result = 100
            }
        }else{
            choice1Result = (nbChoice1 * 100) / (nbChoice1+nbChoice2)
        }
        return "$choice1Result%"
    }

    public fun getChoice2Result() : String {
        var choice2Result : Int = 0
        if(nbChoice1 == 0){
            if(nbChoice2 == 0){
                return "$choice2Result %"
            }else{
                choice2Result = 100
            }
        }else{
            choice2Result = (nbChoice2 * 100) / (nbChoice1+nbChoice2)
        }
        return "$choice2Result%"
    }
}