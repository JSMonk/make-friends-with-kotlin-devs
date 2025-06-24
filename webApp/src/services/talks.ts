import {API_URL} from "@/services/varibles";
import {Talk} from "conference-cms-common";

export function fetchTalkInfo(): Promise<Talk> {
    return fetch(`${API_URL}/talk`)
        .then(x => x.text())
        .then(x => Talk.Companion.fromJson(x))
}

export async function updateTalkInfo(talk: Talk): Promise<void> {
    await fetch(`${API_URL}/talk`, {
        method: "PUT",
        headers: { "Content-Type": "application/json", },
        body: talk.toJson()
    })
}
