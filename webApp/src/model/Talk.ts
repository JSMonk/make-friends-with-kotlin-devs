import type {Speaker} from "@/model/Speaker";

export type Talk = {
    readonly title: string,
    readonly description: string,
    readonly speaker: Speaker
}
