package androidx.compose.ui.autofill;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public interface ContentType {
    public static final Companion Companion = Companion.$$INSTANCE;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class Companion {
        public static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final AndroidContentType EmailAddress;
        public static final AndroidContentType Password;
        public static final AndroidContentType PhoneNumber;

        static {
            ContentType_androidKt.ContentType("username");
            Password = ContentType_androidKt.ContentType("password");
            EmailAddress = ContentType_androidKt.ContentType("emailAddress");
            ContentType_androidKt.ContentType("newUsername");
            ContentType_androidKt.ContentType("newPassword");
            ContentType_androidKt.ContentType("postalAddress");
            ContentType_androidKt.ContentType("postalCode");
            ContentType_androidKt.ContentType("creditCardNumber");
            ContentType_androidKt.ContentType("creditCardSecurityCode");
            ContentType_androidKt.ContentType("creditCardExpirationDate");
            ContentType_androidKt.ContentType("creditCardExpirationMonth");
            ContentType_androidKt.ContentType("creditCardExpirationYear");
            ContentType_androidKt.ContentType("creditCardExpirationDay");
            ContentType_androidKt.ContentType("addressCountry");
            ContentType_androidKt.ContentType("addressRegion");
            ContentType_androidKt.ContentType("addressLocality");
            ContentType_androidKt.ContentType("streetAddress");
            ContentType_androidKt.ContentType("extendedAddress");
            ContentType_androidKt.ContentType("extendedPostalCode");
            ContentType_androidKt.ContentType("personName");
            ContentType_androidKt.ContentType("personGivenName");
            ContentType_androidKt.ContentType("personFamilyName");
            ContentType_androidKt.ContentType("personMiddleName");
            ContentType_androidKt.ContentType("personMiddleInitial");
            ContentType_androidKt.ContentType("personNamePrefix");
            ContentType_androidKt.ContentType("personNameSuffix");
            PhoneNumber = ContentType_androidKt.ContentType("phoneNumber");
            ContentType_androidKt.ContentType("phoneNumberDevice");
            ContentType_androidKt.ContentType("phoneCountryCode");
            ContentType_androidKt.ContentType("phoneNational");
            ContentType_androidKt.ContentType("gender");
            ContentType_androidKt.ContentType("birthDateFull");
            ContentType_androidKt.ContentType("birthDateDay");
            ContentType_androidKt.ContentType("birthDateMonth");
            ContentType_androidKt.ContentType("birthDateYear");
            ContentType_androidKt.ContentType("smsOTPCode");
        }
    }
}
