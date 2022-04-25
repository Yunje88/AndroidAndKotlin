package com.example.tutorials.imagehomework

val commonData : CommonData = CommonData()

class CommonData {

    fun getImageUrlAtIndex(index : Int) : String {

        return if ( index > -1 && index < 11) {
            this.imageUrls[index]
        } else {
            // return default
            this.imageUrls[0]
        }

    }

    fun getImageDescriptionAtIndex(index : Int) : String {
        return if ( index > -1 && index < 11) {
            this.imageDescriptions[index]

        } else {
            this.imageDescriptions[0]
        }
    }

    private val imageUrls : Array<String> = arrayOf(
        "https://www.nps.gov/yose/planyourvisit/images/20170618_155330.jpg",
        "https://people.sc.fsu.edu/~jburkardt/data/jpg/auburn_logo.jpg",
        "https://people.sc.fsu.edu/~jburkardt/data/jpg/bali.jpg",
        "https://people.sc.fsu.edu/~jburkardt/data/jpg/bent_fish.jpg",
        "https://people.sc.fsu.edu/~jburkardt/data/jpg/brain.jpg",
        "https://people.sc.fsu.edu/~jburkardt/data/jpg/brushed_aluminum.jpg",
        "https://people.sc.fsu.edu/~jburkardt/data/jpg/brain_scan.jpg",
        "https://people.sc.fsu.edu/~jburkardt/data/jpg/casablanca.jpg",
        "https://people.sc.fsu.edu/~jburkardt/data/jpg/dome_back1.jpg",
        "https://people.sc.fsu.edu/~jburkardt/data/jpg/dunes1.jpg"
    )
    private val imageDescriptions : Array<String> = arrayOf(
        "snow-covered mountain peak",
        "Auburn logo",
        "bali",
        "bent fish",
        "brain",
        "brushed aluminum",
        "brain scan",
        "casabalanca",
        "backside dome",
        "dunes"
    )
}