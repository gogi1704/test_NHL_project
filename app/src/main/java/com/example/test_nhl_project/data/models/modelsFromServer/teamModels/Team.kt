package com.example.test_nhl_project.data.models.modelsFromServer.teamModels

data class Team(
    val id:Int,
    val name:String,
    val link:String,
    val venue: Venue,
    val abbreviation:String,
    val teamName:String,
    val locationName:String,
    val firstYearOfPlay:String,
    val division: Division,
    val conference: Conference,
    val franchise: Franchise,
    val shortName: String,
    val officialSiteUrl: String,
    val franchiseId:Int,
    val active:Boolean
)


//{
//    "id": 1,
//    "name": "New Jersey Devils",
//    "link": "/api/v1/teams/1",
//    "venue": {
//    "name": "Prudential Center",
//    "link": "/api/v1/venues/null",
//    "city": "Newark",
//    "timeZone": {
//        "id": "America/New_York",
//        "offset": -4,
//        "tz": "EDT"
//    }
//},
//    "abbreviation": "NJD",
//    "teamName": "Devils",
//    "locationName": "New Jersey",
//    "firstYearOfPlay": "1982",
//    "division": {
//    "id": 18,
//    "name": "Metropolitan",
//    "nameShort": "Metro",
//    "link": "/api/v1/divisions/18",
//    "abbreviation": "M"
//},
//    "conference": {
//    "id": 6,
//    "name": "Eastern",
//    "link": "/api/v1/conferences/6"
//},
//    "franchise": {
//    "franchiseId": 23,
//    "teamName": "Devils",
//    "link": "/api/v1/franchises/23"
//},
//    "shortName": "New Jersey",
//    "officialSiteUrl": "http://www.newjerseydevils.com/",
//    "franchiseId": 23,
//    "active": true
//},