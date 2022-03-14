import { Owner } from "./Owner";
import { Model } from "./Model";

export interface CarOwner {
    id?: number,
    owner: Owner,
    model: Model,
    purchaseDate: Date;
    sellDate: Date;
    dateLastEdit: Date;
    statusPractice: String;

}
