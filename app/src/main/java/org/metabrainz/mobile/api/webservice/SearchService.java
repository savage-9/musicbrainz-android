package org.metabrainz.mobile.api.webservice;

import org.metabrainz.mobile.api.data.AccessToken;
import org.metabrainz.mobile.api.data.search.response.ArtistSearchResponse;
import org.metabrainz.mobile.api.data.search.response.EventSearchResponse;
import org.metabrainz.mobile.api.data.search.response.InstrumentSearchResponse;
import org.metabrainz.mobile.api.data.search.response.LabelSearchResponse;
import org.metabrainz.mobile.api.data.search.response.RecordingSearchResponse;
import org.metabrainz.mobile.api.data.search.response.ReleaseGroupSearchResponse;
import org.metabrainz.mobile.api.data.search.response.ReleaseSearchResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface SearchService {

    @FormUrlEncoded
    @POST("https://test.musicbrainz.org/oauth2/token")
    Call<AccessToken> getAccessToken(@Field("code") String code,
                                     @Field("grant_type") String grantType,
                                     @Field("client_id") String clientId,
                                     @Field("client_secret") String clientSecret,
                                     @Field("redirect_uri") String redirectUri);

    @GET("artist/")
    Call<ArtistSearchResponse> searchArtist(@Query("query") String searchTerm,
                                            @Query("limit") String limit,
                                            @Query("offset") String offset);

    @GET("release/")
    Call<ReleaseSearchResponse> searchRelease(@Query("query") String searchTerm,
                                              @Query("limit") String limit,
                                              @Query("offset") String offset);

    @GET("release-group/")
    Call<ReleaseGroupSearchResponse> searchReleaseGroup(@Query("query") String searchTerm,
                                                        @Query("limit") String limit,
                                                        @Query("offset") String offset);

    @GET("label/")
    Call<LabelSearchResponse> searchLabel(@Query("query") String searchTerm,
                                          @Query("limit") String limit,
                                          @Query("offset") String offset);

    @GET("recording/")
    Call<RecordingSearchResponse> searchRecording(@Query("query") String searchTerm,
                                                  @Query("limit") String limit,
                                                  @Query("offset") String offset);

    @GET("instrument/")
    Call<InstrumentSearchResponse> searchInstrument(@Query("query") String searchTerm,
                                                    @Query("limit") String limit,
                                                    @Query("offset") String offset);

    @GET("event/")
    Call<EventSearchResponse> searchEvent(@Query("query") String searchTerm,
                                          @Query("limit") String limit,
                                          @Query("offset") String offset);

}