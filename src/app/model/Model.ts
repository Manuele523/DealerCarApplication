import { Brand } from "./Brand";

export interface Model {
    id?: number,
    code: string,
    title: string,
    brand: Brand
}