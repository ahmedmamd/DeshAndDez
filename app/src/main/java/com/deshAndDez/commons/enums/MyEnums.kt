package com.deshAndDez.commons.enums

class MyEnums {


    /**
     * this enum for determine which login fragment is selected to show
     * LOGIN-> 0 is a tap position for login screen
     * JOIN->1 is a tap position for join screen
     * */
    enum class AuthenticationTypeSelectionEnum(val value: Int) {
        LOGIN(0),
        JOIN(1),
    }
    enum class ChangeEmailOrPhoneOtp(val value: Int) {
        Email(0),
        Phone(1),
    }


    enum class SystemNotificationsStatus(val value: Int) {
        Read(1),
        NotRead(0),
    }
    enum class FCMActionsTypes(val value: String) {
        UpdateLocation("10"),
        UpdateNotificationBadge("500"),
        SignOut("1000")
    }

    enum class VerifySessionStatusType(val value: Int) {
        Ok(0),
        Warning(1),
        Block(2),
    }

    enum class VerifySessionErrorActionType(val value: Int) {
        None(0),
        NavigateToApp(1),
        NavigateToLink(2),
    }

    enum class RequestStatusEnum(val value: Int) {
        Accepted(1),
        Running(2),
        Completed(3),
        Canceled(4),
    }
    enum class TripStatus(val value: Int) {
        Requested(0),
        Accepted(1),
        DriverArrived(2),
        Running(3),
        Canceled(4),
        Completed(5),
    }

    enum class TripTransactionsStatus(val value: Int) {
        Past(0),
        Current(1),
        Upcoming(2)
    }


}
