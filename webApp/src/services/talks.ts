import {API_URL} from "@/services/varibles";
import type {Talk} from "@/model/Talk";

export function fetchTalkInfo(): Promise<Talk> {
    return fetch(`${API_URL}/talk`)
        .then(x => x.json())
}

export async function updateTalkInfo(talk: Talk): Promise<void> {
    await fetch(`${API_URL}/talk`, {
        method: "PUT",
        headers: { "Content-Type": "application/json", },
        body: JSON.stringify(talk)
    })
}
