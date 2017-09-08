package com.tastingnotes.service.client;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Product
{
    @JsonProperty("id")
    private long id;

    @JsonProperty("is_dead")
    private boolean isDead;

    @JsonProperty("name")
    private String name;

    @JsonProperty("tags")
    private String tags;

    @JsonProperty("is_discontinued")
    private boolean isDiscontinued;

    @JsonProperty("price_in_cents")
    private int priceInCents;

    @JsonProperty("regular_price_in_cents")
    private int regularPriceInCents;

    @JsonProperty("limited_time_offer_savings_in_cents")
    private int limitedTimeOfferSavingsInCents;

    @JsonProperty("limited_time_offer_ends_on")
    private LocalDate limitedTimeOfferEndsOn;

    @JsonProperty("bonus_reward_miles")
    private int bonusRewardMiles;

    @JsonProperty("bonus_reward_miles_ends_on")
    private LocalDate bonusRewardMilesEndsOn;

    @JsonProperty("stock_type")
    private String stockType;

    @JsonProperty("primary_category")
    private String primaryCategory;

    @JsonProperty("secondary_category")
    private String secondaryCategory;

    @JsonProperty("origin")
    private String origin;

    @JsonProperty("package")
    private String packageForm;

    @JsonProperty("package_unit_type")
    private String packageUnitType;

    @JsonProperty("package_unit_volume_in_milliliters")
    private int packageUnitVolumeInMilliliters;

    @JsonProperty("total_package_units")
    private int totalPackageUnits;

    @JsonProperty("volume_in_milliliters")
    private int volumeInMilliliters;

    @JsonProperty("alcohol_content")
    private int alcoholContent;

    @JsonProperty("price_per_liter_of_alcohol_in_cents")
    private int pricePerLiterOfAlcoholInCents;

    @JsonProperty("price_per_liter_in_cents")
    private int pricePerLiterInCents;

    @JsonProperty("inventory_count")
    private int inventoryCount;

    @JsonProperty("inventory_volume_in_milliliters")
    private int inventoryVolumeInMilliliters;

    @JsonProperty("inventory_price_in_cents")
    private int inventoryPriceInCents;

    @JsonProperty("sugar_content")
    private String sugarContent;

    @JsonProperty("producer_name")
    private String producerName;

    @JsonProperty("released_on")
    private LocalDate releasedOn;

    @JsonProperty("has_value_added_promotion")
    private boolean hasValueAddedPromotion;

    @JsonProperty("has_limited_time_offer")
    private boolean hasLimitedTimeOffer;

    @JsonProperty("has_bonus_reward_miles")
    private boolean hasBonusRewardMiles;

    @JsonProperty("is_seasonal")
    private boolean isSeasonal;

    @JsonProperty("is_vqa")
    private boolean isVqa;

    @JsonProperty("is_ocb")
    private boolean isOcb;

    @JsonProperty("is_kosher")
    private boolean isKosher;

    @JsonProperty("value_added_promotion_description")
    private boolean valueAddedPromotionDescription;

    @JsonProperty("description")
    private String description;

    @JsonProperty("serving_suggestion")
    private String servingSuggestion;

    @JsonProperty("tasting_note")
    private String tastingNote;

    @JsonProperty("updated_at")
    private LocalDateTime updatedAt;

    @JsonProperty("image_thumb_url")
    private String imageThumbUrl;

    @JsonProperty("image_url")
    private String imageUrl;

    @JsonProperty("varietal")
    private String varietal;

    @JsonProperty("style")
    private String style;

    @JsonProperty("tertiary_category")
    private String tertiaryCategory;

    @JsonProperty("sugar_in_grams_per_liter")
    private int sugarInGramsPerLiter;

    @JsonProperty("clearance_sale_savings_in_cents")
    private int clearanceSaleSavingsInCents;

    @JsonProperty("has_clearance_sale")
    private boolean hasClearanceSale;

    @JsonProperty("product_no")
    private int productNo;

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public boolean isDead()
    {
        return isDead;
    }

    public void setDead(boolean dead)
    {
        isDead = dead;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getTags()
    {
        return tags;
    }

    public void setTags(String tags)
    {
        this.tags = tags;
    }

    public boolean isDiscontinued()
    {
        return isDiscontinued;
    }

    public void setDiscontinued(boolean discontinued)
    {
        isDiscontinued = discontinued;
    }

    public int getPriceInCents()
    {
        return priceInCents;
    }

    public void setPriceInCents(int priceInCents)
    {
        this.priceInCents = priceInCents;
    }

    public int getRegularPriceInCents()
    {
        return regularPriceInCents;
    }

    public void setRegularPriceInCents(int regularPriceInCents)
    {
        this.regularPriceInCents = regularPriceInCents;
    }

    public int getLimitedTimeOfferSavingsInCents()
    {
        return limitedTimeOfferSavingsInCents;
    }

    public void setLimitedTimeOfferSavingsInCents(int limitedTimeOfferSavingsInCents)
    {
        this.limitedTimeOfferSavingsInCents = limitedTimeOfferSavingsInCents;
    }

    public LocalDate getLimitedTimeOfferEndsOn()
    {
        return limitedTimeOfferEndsOn;
    }

    public void setLimitedTimeOfferEndsOn(LocalDate limitedTimeOfferEndsOn)
    {
        this.limitedTimeOfferEndsOn = limitedTimeOfferEndsOn;
    }

    public int getBonusRewardMiles()
    {
        return bonusRewardMiles;
    }

    public void setBonusRewardMiles(int bonusRewardMiles)
    {
        this.bonusRewardMiles = bonusRewardMiles;
    }

    public LocalDate getBonusRewardMilesEndsOn()
    {
        return bonusRewardMilesEndsOn;
    }

    public void setBonusRewardMilesEndsOn(LocalDate bonusRewardMilesEndsOn)
    {
        this.bonusRewardMilesEndsOn = bonusRewardMilesEndsOn;
    }

    public String getStockType()
    {
        return stockType;
    }

    public void setStockType(String stockType)
    {
        this.stockType = stockType;
    }

    public String getPrimaryCategory()
    {
        return primaryCategory;
    }

    public void setPrimaryCategory(String primaryCategory)
    {
        this.primaryCategory = primaryCategory;
    }

    public String getSecondaryCategory()
    {
        return secondaryCategory;
    }

    public void setSecondaryCategory(String secondaryCategory)
    {
        this.secondaryCategory = secondaryCategory;
    }

    public String getOrigin()
    {
        return origin;
    }

    public void setOrigin(String origin)
    {
        this.origin = origin;
    }

    public String getPackageForm()
    {
        return packageForm;
    }

    public void setPackageForm(String packageForm)
    {
        this.packageForm = packageForm;
    }

    public String getPackageUnitType()
    {
        return packageUnitType;
    }

    public void setPackageUnitType(String packageUnitType)
    {
        this.packageUnitType = packageUnitType;
    }

    public int getPackageUnitVolumeInMilliliters()
    {
        return packageUnitVolumeInMilliliters;
    }

    public void setPackageUnitVolumeInMilliliters(int packageUnitVolumeInMilliliters)
    {
        this.packageUnitVolumeInMilliliters = packageUnitVolumeInMilliliters;
    }

    public int getTotalPackageUnits()
    {
        return totalPackageUnits;
    }

    public void setTotalPackageUnits(int totalPackageUnits)
    {
        this.totalPackageUnits = totalPackageUnits;
    }

    public int getVolumeInMilliliters()
    {
        return volumeInMilliliters;
    }

    public void setVolumeInMilliliters(int volumeInMilliliters)
    {
        this.volumeInMilliliters = volumeInMilliliters;
    }

    public int getAlcoholContent()
    {
        return alcoholContent;
    }

    public void setAlcoholContent(int alcoholContent)
    {
        this.alcoholContent = alcoholContent;
    }

    public int getPricePerLiterOfAlcoholInCents()
    {
        return pricePerLiterOfAlcoholInCents;
    }

    public void setPricePerLiterOfAlcoholInCents(int pricePerLiterOfAlcoholInCents)
    {
        this.pricePerLiterOfAlcoholInCents = pricePerLiterOfAlcoholInCents;
    }

    public int getPricePerLiterInCents()
    {
        return pricePerLiterInCents;
    }

    public void setPricePerLiterInCents(int pricePerLiterInCents)
    {
        this.pricePerLiterInCents = pricePerLiterInCents;
    }

    public int getInventoryCount()
    {
        return inventoryCount;
    }

    public void setInventoryCount(int inventoryCount)
    {
        this.inventoryCount = inventoryCount;
    }

    public int getInventoryVolumeInMilliliters()
    {
        return inventoryVolumeInMilliliters;
    }

    public void setInventoryVolumeInMilliliters(int inventoryVolumeInMilliliters)
    {
        this.inventoryVolumeInMilliliters = inventoryVolumeInMilliliters;
    }

    public int getInventoryPriceInCents()
    {
        return inventoryPriceInCents;
    }

    public void setInventoryPriceInCents(int inventoryPriceInCents)
    {
        this.inventoryPriceInCents = inventoryPriceInCents;
    }

    public String getSugarContent()
    {
        return sugarContent;
    }

    public void setSugarContent(String sugarContent)
    {
        this.sugarContent = sugarContent;
    }

    public String getProducerName()
    {
        return producerName;
    }

    public void setProducerName(String producerName)
    {
        this.producerName = producerName;
    }

    public LocalDate getReleasedOn()
    {
        return releasedOn;
    }

    public void setReleasedOn(LocalDate releasedOn)
    {
        this.releasedOn = releasedOn;
    }

    public boolean isHasValueAddedPromotion()
    {
        return hasValueAddedPromotion;
    }

    public void setHasValueAddedPromotion(boolean hasValueAddedPromotion)
    {
        this.hasValueAddedPromotion = hasValueAddedPromotion;
    }

    public boolean isHasLimitedTimeOffer()
    {
        return hasLimitedTimeOffer;
    }

    public void setHasLimitedTimeOffer(boolean hasLimitedTimeOffer)
    {
        this.hasLimitedTimeOffer = hasLimitedTimeOffer;
    }

    public boolean isHasBonusRewardMiles()
    {
        return hasBonusRewardMiles;
    }

    public void setHasBonusRewardMiles(boolean hasBonusRewardMiles)
    {
        this.hasBonusRewardMiles = hasBonusRewardMiles;
    }

    public boolean isSeasonal()
    {
        return isSeasonal;
    }

    public void setSeasonal(boolean seasonal)
    {
        isSeasonal = seasonal;
    }

    public boolean isVqa()
    {
        return isVqa;
    }

    public void setVqa(boolean vqa)
    {
        isVqa = vqa;
    }

    public boolean isOcb()
    {
        return isOcb;
    }

    public void setOcb(boolean ocb)
    {
        isOcb = ocb;
    }

    public boolean isKosher()
    {
        return isKosher;
    }

    public void setKosher(boolean kosher)
    {
        isKosher = kosher;
    }

    public boolean isValueAddedPromotionDescription()
    {
        return valueAddedPromotionDescription;
    }

    public void setValueAddedPromotionDescription(boolean valueAddedPromotionDescription)
    {
        this.valueAddedPromotionDescription = valueAddedPromotionDescription;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getServingSuggestion()
    {
        return servingSuggestion;
    }

    public void setServingSuggestion(String servingSuggestion)
    {
        this.servingSuggestion = servingSuggestion;
    }

    public String getTastingNote()
    {
        return tastingNote;
    }

    public void setTastingNote(String tastingNote)
    {
        this.tastingNote = tastingNote;
    }

    public LocalDateTime getUpdatedAt()
    {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt)
    {
        this.updatedAt = updatedAt;
    }

    public String getImageThumbUrl()
    {
        return imageThumbUrl;
    }

    public void setImageThumbUrl(String imageThumbUrl)
    {
        this.imageThumbUrl = imageThumbUrl;
    }

    public String getImageUrl()
    {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl)
    {
        this.imageUrl = imageUrl;
    }

    public String getVarietal()
    {
        return varietal;
    }

    public void setVarietal(String varietal)
    {
        this.varietal = varietal;
    }

    public String getStyle()
    {
        return style;
    }

    public void setStyle(String style)
    {
        this.style = style;
    }

    public String getTertiaryCategory()
    {
        return tertiaryCategory;
    }

    public void setTertiaryCategory(String tertiaryCategory)
    {
        this.tertiaryCategory = tertiaryCategory;
    }

    public int getSugarInGramsPerLiter()
    {
        return sugarInGramsPerLiter;
    }

    public void setSugarInGramsPerLiter(int sugarInGramsPerLiter)
    {
        this.sugarInGramsPerLiter = sugarInGramsPerLiter;
    }

    public int getClearanceSaleSavingsInCents()
    {
        return clearanceSaleSavingsInCents;
    }

    public void setClearanceSaleSavingsInCents(int clearanceSaleSavingsInCents)
    {
        this.clearanceSaleSavingsInCents = clearanceSaleSavingsInCents;
    }

    public boolean isHasClearanceSale()
    {
        return hasClearanceSale;
    }

    public void setHasClearanceSale(boolean hasClearanceSale)
    {
        this.hasClearanceSale = hasClearanceSale;
    }

    public int getProductNo()
    {
        return productNo;
    }

    public void setProductNo(int productNo)
    {
        this.productNo = productNo;
    }
}